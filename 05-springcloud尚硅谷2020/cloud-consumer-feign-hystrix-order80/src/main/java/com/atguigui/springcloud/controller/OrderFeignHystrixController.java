package com.atguigui.springcloud.controller;

import com.atguigui.springcloud.service.OrderFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@DefaultProperties(defaultFallback = "consumerInfo_TimeOutGlobalHandler")
//@DefaultProperties(defaultFallback = "consumerInfo_TimeOutGlobalHandler",commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000")
//})
@RestController
public class OrderFeignHystrixController {

    @Autowired
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String consumerInfo_OK(@PathVariable("id") Integer id) {

        return orderFeignHystrixService.paymentInfo_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "consumerInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
//    @HystrixCommand
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String consumerInfo_TimeOut(@PathVariable("id") Integer id) {
        return orderFeignHystrixService.paymentInfo_TimeOut(id);
    }

    public String consumerInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "我是80，服务端返回过慢或报错，我自己稍后再试";
    }

    //下面是全局的
    public String consumerInfo_TimeOutGlobalHandler() {
        return "控制器Global降级处理,我是80，服务端返回过慢或报错，我自己稍后再试";
    }
}
