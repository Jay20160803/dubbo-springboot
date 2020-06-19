package com.onlyedu.consumer.configs;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andy on 2020/6/19 16:22
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.onlyedu.consumer.service")
public class DubboConfig {
}
