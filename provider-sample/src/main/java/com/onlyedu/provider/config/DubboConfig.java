package com.onlyedu.provider.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andy on 2020/6/19 16:16
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.onlyedu.provider.service")
public class DubboConfig {
}
