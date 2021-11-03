package cf.mrzhs.mapper;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question LIMIT 0,10")
     List<Question> IndexList();
    

    @Insert("INSERT INTO question" +
            "(title,description,gmt_create,gmt_modified,creator,tag)" +
            "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void addQuestion(Question question);
}
