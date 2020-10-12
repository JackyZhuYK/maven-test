package com.jacky.springbootconfig;

import com.jacky.springbootconfig.pojo.Person;
import com.jacky.springbootconfig.pojo.TestValue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootConfigApplicationTests {

    @Resource
    Person person;

    @Resource
    TestValue testValue;

    @Resource
    ApplicationContext sc;

    @Test
    void contextLoads() {
        System.out.println(person.toString());
    }

    @Test
    void sayHello() {
        testValue.sayHello();
    }

    @Test
    void testBean() {
        boolean b = sc.containsBean("helloBeanService01");
        System.out.println(b);
    }

}
