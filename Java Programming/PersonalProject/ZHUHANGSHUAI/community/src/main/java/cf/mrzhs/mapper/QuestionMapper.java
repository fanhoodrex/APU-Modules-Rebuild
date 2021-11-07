package cf.mrzhs.mapper;

import cf.mrzhs.dto.QuestionDTO;
import cf.mrzhs.pojo.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question ORDER BY gmt_create DESC LIMIT #{offSet},#{size}")
     List<Question> IndexList(@Param("offSet") Integer offSet, 
                              @Param("size") Integer size);
    

    @Insert("INSERT INTO question" +
            "(title,description,gmt_create,gmt_modified,creator,tag)" +
            "VALUES (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void addQuestion(Question question);
    
    @Select("SELECT COUNT(1) FROM question")
    Integer count();
    
    @Select("SELECT * FROM question WHERE id=#{id}")
    Question getQuestionById(@Param("id") Integer id);
    
    @Update("UPDATE question SET title=#{title},description=#{description}, tag=#{tag} WHERE id=#{id}")
    void modify(@Param("title") String title,
                    @Param("description") String description,
                    @Param("tag") String tag,
                    @Param("id") Integer id);
    
    @Update("UPDATE question SET view_count=#{view} WHERE id = #{id}")
    void addView(@Param("view") Integer view,
                 @Param("id") Integer id);
    
    @Update("UPDATE question SET comment_count = #{count} WHERE id = #{id}")
    void addComment(@Param("count")Integer commentCount,
                    @Param("id") Integer id);
    
    @Select("SELECT * FROM question WHERE title LIKE '%${title}%' ORDER BY gmt_create DESC")
    List<Question> getQuestionByTitle(@Param("title") String title);
}
