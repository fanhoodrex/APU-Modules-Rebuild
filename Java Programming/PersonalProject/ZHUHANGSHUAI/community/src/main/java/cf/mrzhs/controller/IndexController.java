package cf.mrzhs.controller;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.mapper.QuestionMapper;
import cf.mrzhs.pojo.Question;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.CheckProvider;
import cf.mrzhs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private CheckProvider checkProvider;
    @Autowired
    private QuestionService questionService;

    @GetMapping({"/","/index.html","/index"})
    public String indexPage(Model m,
                            HttpServletRequest request){
        User user = checkProvider.checkLoginUser(request.getCookies());
        if (user != null){
            request.getSession().setAttribute("user",user);
        }
//        因为前端渲染页面需要用户头像的url,但是Question对象模型没有,需要用它的DTO模型
        List<QuestionDTO> indexList = questionService.IndexList();
        m.addAttribute("questions",indexList);
        return "index";
    }
}
