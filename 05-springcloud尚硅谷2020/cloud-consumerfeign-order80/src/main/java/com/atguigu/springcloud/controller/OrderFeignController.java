package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.queryPaymentById(id);
    }

    @GetMapping(value = "/payment/lb/timeout")
    public String getPaymentLBTimeout() {
        return paymentFeignService.getPaymentLBTimeout();
    }
}
