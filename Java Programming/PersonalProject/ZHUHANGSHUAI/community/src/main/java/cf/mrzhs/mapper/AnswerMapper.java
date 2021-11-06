package cf.mrzhs.mapper;

import cf.mrzhs.pojo.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    @Select("SELECT * FROM answer where parent_id = #{parentId}")
    List<Answer> getAnswersByParent(@Param("parentId")Integer id);
}
