package com.vinnilmg.paymentservice.service.impl;

import com.vinnilmg.paymentservice.model.Payment;
import com.vinnilmg.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento: {}", payment.toString());

        Thread.sleep(1000);

        log.info("Enviando o pagamento...");
        kafkaTemplate.send(topicName, payment);
    }

}
