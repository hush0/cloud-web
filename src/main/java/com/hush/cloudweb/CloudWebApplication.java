package com.hush.cloudweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: huangshuai
 */

@EnableEurekaClient
@SpringBootApplication
public class CloudWebApplication {

    private static Logger logger = LoggerFactory.getLogger(CloudWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudWebApplication.class, args);
        logger.info("Application started !");
    }

}
