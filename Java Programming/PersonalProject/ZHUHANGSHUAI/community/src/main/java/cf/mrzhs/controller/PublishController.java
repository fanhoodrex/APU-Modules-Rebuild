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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    
    @Autowired
    private CheckProvider checkProvider;
    
    @Autowired
    private QuestionService questionService;
    
    
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
    
    @GetMapping("/modify")
    public String modifiedQuestion(@RequestParam("id") Integer id,
                                    Model model){
        Question question = questionMapper.getQuestionById(id);
        
        model.addAttribute("targetQuestion",question);
        return "modify";
    }
    
    @PostMapping("/modify")
    public String commitModify(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam("id") Integer id,
            Model model
    ){
        questionMapper.modify(title, description, tag, id);
        QuestionDTO question = questionService.getQuestionById(id);
        model.addAttribute("targetQuestion",question);
        model.addAttribute("user",question.getUser());
        String[] tags = tag.split(",");
        model.addAttribute("tags",tags);
        return "singleQuestion";
    }
}
