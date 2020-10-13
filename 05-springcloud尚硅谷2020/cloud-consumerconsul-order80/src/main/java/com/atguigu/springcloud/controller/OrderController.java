package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final static String PAYMENT = "http://consul-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String queryConsul(){
        return restTemplate.getForObject(PAYMENT+"/payment/consul",String.class);
    }
}
