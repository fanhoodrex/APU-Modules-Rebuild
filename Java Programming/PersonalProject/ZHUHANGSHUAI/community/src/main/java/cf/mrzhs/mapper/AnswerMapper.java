package cf.mrzhs.mapper;

import cf.mrzhs.pojo.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    @Select("SELECT * FROM answer WHERE parent_id = #{parentId} ORDER BY gmt_create DESC")
    List<Answer> getAnswersByParent(@Param("parentId")Integer id);
    
    @Insert("INSERT INTO answer (parent_id,answer_name,content,gmt_create,gmt_modified) " +
            "VALUES(#{parentId},#{answerName},#{content},#{gmtCreate},#{gmtModified})")
    void addAnswer(Answer answer);
}
