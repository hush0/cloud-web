package com.hush.cloudweb.config;

import com.hush.cloudweb.constant.ApplicationProfile;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

/**
 * @Author: huangshuai
 * @Date: 2019-08-02
 * @Version 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {

        //prod环境禁用SwaggerUI
        Predicate<String> path = PathSelectors.any()::apply;
        if (ApplicationProfile.isProductProfile()) {
            path = PathSelectors.none()::apply;
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(path::test)
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("cloud_web Api Documentation")
                .description("Api Documentation")
                .version("1.0").build();
    }
}
