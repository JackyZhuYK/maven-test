package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final static String PAYMENT = "http://cloud-payment-service";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String queryZk(){
        return restTemplate.getForObject(PAYMENT+"/payment/zk",String.class);
    }
}
