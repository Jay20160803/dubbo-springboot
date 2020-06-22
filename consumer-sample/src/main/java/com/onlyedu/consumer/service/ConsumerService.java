package com.onlyedu.consumer.service;

import com.onlyedu.sample.consumer.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Andy on 2020/6/19 16:23
 */
@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(version = "${demo.service.version}")
    private DemoService demoService;


    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }

}
