package cf.mrzhs.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean setViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean
                = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> setting = new HashMap<>();
        setting.put("loginUsername","admin");
        setting.put("loginPassword","admin");
        setting.put("allow","");
        bean.setInitParameters(setting);
        return bean;
    }
}
