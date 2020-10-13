package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    PaymentService paymentService;

    @Autowired
    DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object queryDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for(String serviceId : services) {
            log.info("service:" + serviceId);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);

            for(ServiceInstance serviceInstance : serviceInstances){
                log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getInstanceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
            }
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping(value = "/payment/lb/timeout")
    public String getPaymentLBTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
