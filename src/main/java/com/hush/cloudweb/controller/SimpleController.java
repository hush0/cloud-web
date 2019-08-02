package com.hush.cloudweb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangshuai
 * @Date: 2019-08-02
 * @Version 1.0
 */
@Api(description = "简单示例")
@RestController
@RequestMapping("/simple")
public class SimpleController {

    @GetMapping(value ="/hello")
    @ApiOperation(value = "helloWorld")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query")
    public String hello(String name){
        return "hello world! "+name;
    }

}
