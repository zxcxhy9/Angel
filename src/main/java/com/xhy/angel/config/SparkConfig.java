package com.xhy.angel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spark")
@Data
public class SparkConfig {

    private String appName;

    private String master;

    private String sparkHome;
}