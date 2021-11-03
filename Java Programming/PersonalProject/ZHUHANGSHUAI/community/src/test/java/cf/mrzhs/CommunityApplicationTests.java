package cf.mrzhs;

import cf.mrzhs.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    TestMapper mapper;
    @Test
    void contextLoads() {
        User byId = mapper.findById("d4cde660-dbba-46f9-9bf5-7f091dd13d0a");
        System.out.println(byId);
    }

}
