package com.springlearn.ch3.fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TestBean devTestBean() {
        return new TestBean("这是个dev的bean");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTestBean() {
        return new TestBean("这是个prod的bean");
    }
}
