package cf.mrzhs.controller;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.mapper.AnswerMapper;
import cf.mrzhs.mapper.QuestionMapper;
import cf.mrzhs.pojo.Answer;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.CheckProvider;
import cf.mrzhs.service.QuestionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SingleQuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CheckProvider provider;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    
    @GetMapping("/singleQuestion")
    public String single(@RequestParam("id") Integer questionId,
                         @RequestParam("view") Integer view,
                         Model model,
                         HttpServletRequest request){
//        每次点击,阅读数+1
        questionMapper.addView(view+1,questionId);
//        获取user和question的复合类
        QuestionDTO questionDto = questionService.getQuestionById(questionId);
        User user = provider.checkLoginUser(request.getCookies());
        if (user == null){
            user = new User();
        }
        String tag = questionDto.getTag();
        String[] tags = tag.split(",");
        
        List<Answer> answers = answerMapper.getAnswersByParent(questionDto.getId());
        model.addAttribute("targetQuestion", questionDto);
        model.addAttribute("user",user);
        if (answers.size() == 0){
            Answer answer = new Answer(0,0,"看起来没有人回复过","您可以通过下面回复栏进行回复",0L,0L);
            answers.add(answer);
            model.addAttribute("answers",answers);
        }else {
            model.addAttribute("answers",answers);
        }
        model.addAttribute("tags",tags);
        return "singleQuestion";
    }
    @PostMapping("/addComment")
    public String addComment(
            @RequestParam("comment")String comment,
            @RequestParam("commentName") String commentName,
            @RequestParam("questionId")Integer id,
            Model model,
            HttpServletRequest request
    ){
        Answer answer = new Answer();
        answer.setAnswerName(commentName);
        answer.setContent(comment);
        answer.setParentId(id);
        answer.setGmtCreate(System.currentTimeMillis());
        answer.setGmtModified(answer.getGmtCreate());
        answerMapper.addAnswer(answer);
        QuestionDTO questionDto = questionService.getQuestionById(id);
        User user = provider.checkLoginUser(request.getCookies());
        if (user == null){
            user = new User();
        }
        questionMapper.addComment(questionDto.getCommentCount()+1,questionDto.getId());
        List<Answer> answers = answerMapper.getAnswersByParent(questionDto.getId());
        model.addAttribute("targetQuestion", questionDto);
        model.addAttribute("user",user);
        if (answers.size() == 0){
            answer = new Answer(0,0,"看起来没有人回复过","您可以通过下面回复栏进行回复",0L,0L);
            answers.add(answer);
            model.addAttribute("answers",answers);
        }else {
            model.addAttribute("answers",answers);
        }
        String tag = questionDto.getTag();
        String[] tags = tag.split(",");
        model.addAttribute("tags",tags);
        return "singleQuestion";
    }
}
