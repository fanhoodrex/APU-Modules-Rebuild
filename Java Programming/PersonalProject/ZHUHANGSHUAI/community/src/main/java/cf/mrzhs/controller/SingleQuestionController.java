package cf.mrzhs.controller;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SingleQuestionController {
    @Autowired
    private QuestionService questionService;
    
    
    @GetMapping("/singleQuestion")
    public String single(@RequestParam("id") Integer questionId,
                         Model model){
        QuestionDTO questionDto = questionService.getQuestionById(questionId);
        model.addAttribute("targetQuestion", questionDto);
        
        return "singleQuestion";
    }
}
