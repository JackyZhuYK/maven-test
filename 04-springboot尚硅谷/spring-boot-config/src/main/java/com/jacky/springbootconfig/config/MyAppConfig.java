package com.jacky.springbootconfig.config;

import com.jacky.springbootconfig.service.HelloBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloBeanService helloBeanService01(){
        System.out.println("加载HelloBeanService成功");
        return new HelloBeanService();
    }
}
