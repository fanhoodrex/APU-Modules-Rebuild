package cf.mrzhs.service;

import cf.mrzhs.dto.PageDTO;
import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.mapper.QuestionMapper;
import cf.mrzhs.mapper.UserMapper;
import cf.mrzhs.pojo.Question;
import cf.mrzhs.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    
    public PageDTO IndexList(Integer page, Integer size) {
        Integer offSet = size*(page-1);
        List<Question> questionList = questionMapper.IndexList(offSet,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            将类的属性一一对应赋值,省去了单独写set方法
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
//            通过当前时间减去修改时间来判断多少分钟前修改
            questionDTO.setGmtModified(System.currentTimeMillis() - question.getGmtModified());
            questionDTOList.add(questionDTO);
            
            
        }
//        总页数
        Integer totalCount = questionMapper.count();
        PageDTO pageDTO = new PageDTO();
        pageDTO.setQuestions(questionDTOList);
        pageDTO.setPagination(totalCount,page,size);
        
        return pageDTO;
    }
    
    public QuestionDTO getQuestionById(Integer id){
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.getQuestionById(id);
        User user = userMapper.findById(question.getCreator());
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
    public QuestionDTO getQuestionDTO(Question question){
        QuestionDTO questionDTO = new QuestionDTO();
        User user = userMapper.findById(question.getCreator());
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
}
