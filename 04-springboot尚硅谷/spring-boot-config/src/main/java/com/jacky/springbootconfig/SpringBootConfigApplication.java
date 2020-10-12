package com.jacky.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource: 加载xml,Springboot中不推荐使用xml，推荐使用配置类的方式加载
 */
@SpringBootApplication
//@ImportResource(value={"classpath:bean.xml"})
public class SpringBootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

}
