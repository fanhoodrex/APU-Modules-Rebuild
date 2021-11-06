package cf.mrzhs.mapper;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.pojo.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question LIMIT #{offSet},#{size}")
     List<Question> IndexList(@Param("offSet") Integer offSet, 
                              @Param("size") Integer size);
    

    @Insert("INSERT INTO question" +
            "(title,description,gmt_create,gmt_modified,creator,tag)" +
            "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void addQuestion(Question question);
    
    @Select("SELECT COUNT(1) FROM question")
    Integer count();
    
    @Select("SELECT * FROM question WHERE id=#{id}")
    Question getQuestionById(@Param("id") Integer id);
    
    @Update("UPDATE question set title=#{title},description=#{description}, tag=#{tag} where id=#{id}")
    void modify(@Param("title") String title,
                    @Param("description") String description,
                    @Param("tag") String tag,
                    @Param("id") Integer id);
    
    @Update("UPDATE question set view_count=#{view} where id = #{id}")
    void addView(@Param("view") Integer view,
                 @Param("id") Integer id);
}
