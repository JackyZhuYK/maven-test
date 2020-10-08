package com.springlearn.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.springlearn.ch2.el")
@PropertySource("classpath:com/springlearn/ch2/el/test.properties")
public class ElConfig {

    //注入普通字符串
    @Value("I Love You!")
    private String normal;

    //注入操作系统属性
    @Value("#systemProperties['os.name']")
    private String osName;

    //注入表达式结果
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    //注入其他Bean属性
    @Value("#{demoService.another}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:com/springlearn/ch2/el/test.txt")
    private Resource testFile;

    //注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入配置文件 1
    @Value("${book.name}")
    private String bookName;

    @Autowired
    Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try{
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream(),"utf-8"));
            System.out.println(IOUtils.toString(testUrl.getInputStream(),"utf-8"));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.name"));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
