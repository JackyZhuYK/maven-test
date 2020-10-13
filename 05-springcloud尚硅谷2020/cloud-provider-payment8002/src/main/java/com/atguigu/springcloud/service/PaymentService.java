package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    long createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
