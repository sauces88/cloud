package com.sliny.cloud.service;

import com.sliny.cloud.entity.Payment;
import com.sliny.cloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

/**
 * @date 2020/10/11 17:54
 */
@Service
public class PaymentService{
    private PaymentMapper paymentMapper;

    public PaymentService(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }
}
