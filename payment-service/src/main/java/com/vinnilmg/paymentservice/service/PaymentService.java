package com.vinnilmg.paymentservice.service;

import com.vinnilmg.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
