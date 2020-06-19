package com.onlyedu.provider.service;


import com.onlyedu.sample.consumer.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * Created by Andy on 2020/6/19 15:01
 */
@DubboService(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Random costTimeRandom = new Random();

    @Value("${dubbo.application.name}")
    private String serviceName;


    @Override
    public String sayHello(String name) {

        await();

        return String.format("[%s] : Hello, %s", serviceName, name);
    }


    private void await(){

        try{
            long timeInMillisToWait = costTimeRandom.nextInt(500);
            Thread.sleep(timeInMillisToWait);
            logger.info("execution time : " + timeInMillisToWait + " ms.");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
