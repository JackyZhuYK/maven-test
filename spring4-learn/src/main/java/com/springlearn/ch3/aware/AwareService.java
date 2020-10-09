package com.springlearn.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称为:" + beanName);
        Resource resource = loader.getResource("classpath:com/springlearn/ch3/aware/test.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream(),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
