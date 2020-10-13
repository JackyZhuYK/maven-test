package com.atguigui.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignHystrixHandlerService implements OrderFeignHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "feign实现类里的降级处理paymentInfo_OK，Thread:"+Thread.currentThread().getName();
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "feign实现类里的降级处理paymentInfo_TimeOut，Thread:"+Thread.currentThread().getName();
    }
}
