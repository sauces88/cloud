package com.sliny.cloud.controller;

import com.sliny.cloud.entity.CommonResult;
import com.sliny.cloud.entity.Payment;
import com.sliny.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2020/10/11 17:54
 */
@RestController
@Slf4j
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        if (result > 0)
            return CommonResult.success(result);
        return CommonResult.failed();
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：["+payment+"]");
        if (payment != null)
            return CommonResult.success(payment);
        return CommonResult.failed();
    }
}
