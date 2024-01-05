package com.vinnilmg.strconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "${kafka.topic-name}", containerFactory = "strContainerFactory")
    public void listener(String message) {
        log.info("Mensagem recebida: {}", message);
    }

}
