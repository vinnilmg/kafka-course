package com.vinnilmg.strconsumer.listeners;

import com.vinnilmg.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void listener1(String message) {
        log.info("[listener 1] Mensagem recebida: {}", message);
        throw new IllegalArgumentException("Exception...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener2(String message) {
        log.info("[listener 2] Mensagem recebida: {}", message);
    }

    // ContainerFactory alterado para o que tem o interceptador
    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void listener3(String message) {
        log.info("[listener 3] Mensagem recebida: {}", message);
    }

}
