package com.xhy.angel;

import com.xhy.angel.common.spark.SparkJob;
import com.xhy.angel.common.utils.SpringBootBeanUtils;
import com.xhy.angel.config.SparkConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkJobInfo;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.Utils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.xhy.angel.infrastructure.mapper", annotationClass = Mapper.class)
@ComponentScan(basePackages = "com.xhy.angel.*")
@EnableSwagger2
@EnableAdminServer
@EnableAsync
public class AngelApplication implements CommandLineRunner {

    @Autowired
    SparkConfig sparkConfig;

    public static void main(String[] args) {
        SpringApplication.run(AngelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SparkConf sparkConf = new SparkConf()
                .setAppName(sparkConfig.getAppName())
                .setMaster(sparkConfig.getMaster());

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        String className = "com.xhy.angel.statistics.job.StatisticsJob";
        Class clazz = Utils.classForName(className);
        Object sparkJob = SpringBootBeanUtils.getBean(clazz);

        if(sparkJob instanceof SparkJob) {
            ((SparkJob) sparkJob).execute(javaSparkContext);
        }
    }
}
