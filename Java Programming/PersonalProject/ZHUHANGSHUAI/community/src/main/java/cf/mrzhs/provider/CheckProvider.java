package cf.mrzhs.provider;

import cf.mrzhs.mapper.UserMapper;
import cf.mrzhs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
@Component
public class CheckProvider {
    @Autowired
    private UserMapper userMapper;
    
    public  User checkLoginUser(Cookie[] cookies){
        User user = null;
//        未登录状态
        if (cookies == null){
            return user;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                return user;
            }
        }
        return user;
    }
}
