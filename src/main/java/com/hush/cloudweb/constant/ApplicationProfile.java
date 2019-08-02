package com.hush.cloudweb.constant;


import com.google.common.collect.Lists;
import com.hush.cloudweb.util.BeanUtil;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2019-08-02
 * @Version 1.0
 */
public class ApplicationProfile {

    public static final String DEVELOP_ENVIROMENT  = "dev";
    public static final String TEST_ENVIROMENT     = "test";
    public static final String PRODUCT_ENVIROMENT  = "prod";

    public static List<String> getCurrentProfiles() {
        Environment environment = BeanUtil.getBean(Environment.class);
        return Lists.newArrayList(environment.getActiveProfiles());
    }

    public static boolean isProfileOf(String profile) {
        return getCurrentProfiles().contains(profile);
    }

    public static boolean isProductProfile() {
        return isProfileOf(PRODUCT_ENVIROMENT);
    }

    public static boolean isTestProfile() {
        return isProfileOf(TEST_ENVIROMENT);
    }

    public static boolean isDevelopProfile() {
        return isProfileOf(DEVELOP_ENVIROMENT);
    }
}
