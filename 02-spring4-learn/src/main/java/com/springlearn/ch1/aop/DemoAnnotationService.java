package com.springlearn.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name="注解试拦截的add操作")
    public void add(){}
}