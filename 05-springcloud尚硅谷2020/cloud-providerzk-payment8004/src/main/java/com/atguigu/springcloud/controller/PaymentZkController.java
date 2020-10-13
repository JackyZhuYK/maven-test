package com.atguigu.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentZkController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String getZk(){
        return "这是个zk的服务端,port:"+port+",UUID:"+ UUID.randomUUID().toString();
    }
}
