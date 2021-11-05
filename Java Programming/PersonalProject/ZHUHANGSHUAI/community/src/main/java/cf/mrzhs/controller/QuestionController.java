package cf.mrzhs.controller;

import cf.mrzhs.mapper.MyQuestionsMapper;
import cf.mrzhs.pojo.MyQuestions;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.CheckProvider;
import cf.mrzhs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private MyQuestionsMapper myQuestionsMapper;
    @Autowired
    private CheckProvider checkProvider;
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/profile/questions")
    public String myQuestions(@RequestParam("id") String id,
                              Model model,
                              HttpServletRequest request){
        
        
        List<MyQuestions> allMyQuestions = myQuestionsMapper.getAllMyQuestions(id);
        model.addAttribute("allQuestions",allMyQuestions);
        
        return "questions";
    }
}
