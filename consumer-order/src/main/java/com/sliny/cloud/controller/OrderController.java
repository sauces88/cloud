package com.sliny.cloud.controller;

import com.sliny.cloud.entity.CommonResult;
import com.sliny.cloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @date 2020/10/11 17:55
 */
@RestController
public class OrderController {
    private final static String INVOKE_URL  = "http://payment-service-3002/";
    private RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(INVOKE_URL+"payment/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/payment/insert")
    public CommonResult insert(@RequestBody Payment payment){
        return restTemplate.postForObject(INVOKE_URL + "payment/insert", payment, CommonResult.class);
    }

}
