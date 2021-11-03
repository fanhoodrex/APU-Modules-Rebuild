package cf.mrzhs;

import cf.mrzhs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestMapper {
    @Select("SELECT * FROM user WHERE account_id = #{id}")
    User findById(@Param("id") String id);
}
