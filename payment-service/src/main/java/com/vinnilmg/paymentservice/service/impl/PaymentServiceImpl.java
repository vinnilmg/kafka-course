package com.vinnilmg.paymentservice.service.impl;

import com.vinnilmg.paymentservice.model.Payment;
import com.vinnilmg.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento: {}", payment.toString());
    }

}
