package com.xhy.angel;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.xhy.angel.infrastructure.mapper", annotationClass = Mapper.class)
@ComponentScan(basePackages = "com.xhy.angel.*")
@EnableSwagger2
public class AngelApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AngelApplication.class, args);
        String[] beanNamesForType = run.getBeanNamesForType(PlatformTransactionManager.class);
        for(String s : beanNamesForType) {
            if( s.contains("anger")) {
                System.out.println(s);
            }
        }
    }
}
