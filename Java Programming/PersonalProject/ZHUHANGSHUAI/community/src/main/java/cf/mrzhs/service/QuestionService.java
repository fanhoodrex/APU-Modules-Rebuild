package cf.mrzhs.service;

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
    
    public List<QuestionDTO> IndexList() {
        List<Question> questionList = questionMapper.IndexList();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            将类的属性一一对应赋值,省去了单独写set方法
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
//            通过当前时间减去修改时间来判断多少分钟前修改
            
            questionDTO.setGmtModified(System.currentTimeMillis() - question.getGmtModified());
            System.out.println(questionDTO.getGmtModified());
            questionDTOList.add(questionDTO);
            
        }
        return questionDTOList;
    }
}
