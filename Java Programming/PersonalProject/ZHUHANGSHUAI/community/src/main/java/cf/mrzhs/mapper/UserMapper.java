package cf.mrzhs.mapper;

import cf.mrzhs.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("INSERT INTO " +
            "user (github_id, account_name, account_token, gmt_create, gmt_modified,avatar_url) " +
            "VALUES (#{githubId},#{accountName},#{accountToken},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
    
    @Select("SELECT * FROM user WHERE account_token = #{token}")
    User findByToken(@Param("token") String token);
    
    @Select("SELECT * FROM user WHERE github_id = #{id}")
    User findByGithubId(@Param("id") Integer id);
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Integer id);
}
