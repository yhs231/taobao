package cn.edu.ncu.yhs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TaobaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaobaoApplication.class, args);
    }

}
