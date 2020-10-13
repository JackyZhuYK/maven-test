package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentZkMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentZkMain8004.class, args);
    }
}
