package com.vinnilmg.paymentservice.resource.impl;

import com.vinnilmg.paymentservice.model.Payment;
import com.vinnilmg.paymentservice.resource.PaymentResource;
import com.vinnilmg.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
