package com.vinnilmg.jsonconsumer.listener;

import com.vinnilmg.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Slf4j
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic-name}", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Pagamento recebido: {}", payment.toString());
        sleep(2000);

        log.info("Validando fraude...");
        sleep(2000);

        log.info("Compra aprovada...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic-name}", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        log.info("Gerando PDF do produto de ID: {}", payment.getProductId());
        sleep(3000);
    }

    @KafkaListener(topics = "${kafka.topic-name}", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) {
        log.info("Enviado email de confirmação para o usuário: {}", payment.getUserId());
    }

}
