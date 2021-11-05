package cf.mrzhs.controller;

import cf.mrzhs.mapper.QuestionMapper;
import cf.mrzhs.mapper.UserMapper;
import cf.mrzhs.pojo.Question;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.CheckProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    
    @Autowired
    private CheckProvider checkProvider;
    
    
    
    @GetMapping("/publish")
    public String publish(
            Model m,
            HttpServletRequest request
    ) {
        User user = checkProvider.checkLoginUser(request.getCookies());
        
        if (user != null){
            request.getSession().setAttribute("user",user);
        }
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            Model model,
            HttpServletRequest request
    ) {
        User user = checkProvider.checkLoginUser(request.getCookies());
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.addQuestion(question);
        return "redirect:/index";
    }
}
