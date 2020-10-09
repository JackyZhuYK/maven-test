package com.springlearn.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean1 = context.getBean(DemoBean.class);
        System.out.println(demoBean1.getContent());
        context.close();

        context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();
        DemoBean demoBean2 = context.getBean(DemoBean.class);
        System.out.println(demoBean2.getContent());
        context.close();

    }
}
