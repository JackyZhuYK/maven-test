package com.jacky.springbootconfig;

import com.jacky.springbootconfig.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootConfigApplicationTests {

    @Resource
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person.toString());
    }

}
