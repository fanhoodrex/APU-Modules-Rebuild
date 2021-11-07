package cf.mrzhs.mapper;

import cf.mrzhs.pojo.MyQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyQuestionsMapper {
    @Select("SELECT * FROM question WHERE creator = #{id} ORDER BY gmt_create DESC")
    List<MyQuestions> getAllMyQuestions(@Param("id") String id);
}
