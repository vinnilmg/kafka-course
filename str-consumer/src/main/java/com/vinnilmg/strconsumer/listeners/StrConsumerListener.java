package com.vinnilmg.strconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-0", topics = "${kafka.topic-name}", containerFactory = "strContainerFactory")
    public void listener1(String message) {
        log.info("[listener 1] Mensagem recebida: {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "${kafka.topic-name}", containerFactory = "strContainerFactory")
    public void listener2(String message) {
        log.info("[listener 2] Mensagem recebida: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "${kafka.topic-name}", containerFactory = "strContainerFactory")
    public void listener3(String message) {
        log.info("[listener 3] Mensagem recebida: {}", message);
    }

}
