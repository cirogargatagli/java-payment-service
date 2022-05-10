package com.ajsw.java.payment.service.controllers;

import com.ajsw.java.payment.service.services.PaymentService;
import com.ajsw.java.payment.service.models.dto.request.PaymentMPRequest;
import com.ajsw.java.payment.service.models.dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public Response payWithMP(@Validated @RequestBody PaymentMPRequest paymentRequest){
        try {
            return paymentService.payWithMP(paymentRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}
