package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBanlance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBanlance loadBanlance;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/payment")
    public CommonResult<Long> createPayment(String serial){
        Payment payment = new Payment();
        payment.setSerial(serial);
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }

    @GetMapping("/payment/createForEntity/")
    public CommonResult<Long> createPaymentForEntity(String serial){
        Payment payment = new Payment();
        payment.setSerial(serial);

        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL+"/payment",payment,CommonResult.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444,"操作错误");
        }
    }

    @GetMapping("/payment/queryForEntity/{id}")
    public CommonResult<Payment> queryPaymentByIdForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/"+id,CommonResult.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444,"操作错误");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBanlance.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info(uri.toString());
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
