package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult<Long> createPayment(@RequestBody Payment payment){
        long id = paymentService.createPayment(payment);
        log.info("******插入成功，返回id:"+id+"*****");
        if(id != 0L){
            return new CommonResult<>(200,"插入数据成功,port:"+port,id);
        }else{
            return new CommonResult<>(444,"插入数据失败,port:"+port);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询成功，返回结果为:"+payment+"*****");
        if(payment!=null){
            return new CommonResult<>(200,"查询数据成功,port:"+port,payment);
        }else {
            return new CommonResult<>(444,"查询数据失败,port:"+port);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
