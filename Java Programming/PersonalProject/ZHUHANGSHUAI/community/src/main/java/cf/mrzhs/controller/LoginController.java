package cf.mrzhs.controller;

import cf.mrzhs.dto.AccessTokenPOJO;
import cf.mrzhs.dto.GithubUser;
import cf.mrzhs.mapper.UserMapper;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private GithubProvider provider;
    @Autowired
    private UserMapper mapper;
    @Value("${github.client.id}")
    private String Client_id;
    @Value("${github.client.secret}")
    private String Client_secret;
    @Value("${github.client.uri}")
    private String Client_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
//        将用户请求的本次数据存入到一个对象中
        AccessTokenPOJO accessTokenPOJO =
                new AccessTokenPOJO(Client_id,
                        Client_secret,
                        code,
                        Client_uri,
                        state);
//          通过github应用程序来获取用户的token

        String accessToken = provider.getAccessToken(accessTokenPOJO);
        GithubUser githubUser = provider.getUser(accessToken);
        User targetUser = mapper.findByGithubId(githubUser.getId());
//        如果用户已经存在于数据库
        if (targetUser != null) {
            response.addCookie(new Cookie("token", targetUser.getAccountToken()));
            return "redirect:/index";
        } else {
//            如果是一个新用户
            String uuid = UUID.randomUUID().toString();
            User user = new User();

            user.setAccountName(githubUser.getName());
            user.setAccountToken(uuid);
            user.setGithubId(githubUser.getId());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatar_url());
            mapper.insert(user);
            response.addCookie(new Cookie("token", uuid));

            return "redirect:/index";
        }
    }

}
