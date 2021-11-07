package cf.mrzhs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket servlet(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Servlet")
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());    
    }
    private ApiInfo apiInfo(){
//        写上一些作者信息
        Contact zhs = new Contact("朱航帅", "https://github.com/NoString", "pro6@qq.com");
//        ApiInfo这个类没有set方法,只能在实例化的时候通过有参构造来进行传参
        return new ApiInfo(
                "一个swaggerwe文档",
                "记录该项目的所有Servlet调用地址",
                "v1.0",
                "https://github.com/NoString",
                zhs,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
