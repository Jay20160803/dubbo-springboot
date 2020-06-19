package com.onlyedu.consumer.service;

import com.onlyedu.sample.consumer.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
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


    @DubboReference(
            version = "1.0.0",
            url = "dubbo://127.0.0.1:12345",
            timeout = 100,
            methods = {
                    @Method(name = "sayHello", timeout = 300)
            }
    )
    private DemoService demoService;



    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }
}
