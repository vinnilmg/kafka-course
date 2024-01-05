package com.vinnilmg.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic-name}")
    private String topicName;

    public void sendMessage(String message) {
        log.info("Enviando mensagem: {}", message);
        kafkaTemplate.send(topicName, message).addCallback(
                success -> {
                    if (nonNull(success)) {
                        log.info("Mensagem enviada com sucesso.");
                        log.info("Partition: {}", success.getRecordMetadata().partition());
                        log.info("Offset: {}", success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Erro ao enviar mensagem: {}", error.getMessage(), error)
        );
    }

}
