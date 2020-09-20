package com.jacky.springbootconfig.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Value:加载单项配置
 */
@Component
@PropertySource(value={"classpath:person.properties"})
public class TestValue {

    @Value("${person.name}")
    private String name;

    public void sayHello(){
        System.out.println("hello " + name);
    }
}
