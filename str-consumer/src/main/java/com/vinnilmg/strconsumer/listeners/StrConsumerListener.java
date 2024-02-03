package com.vinnilmg.strconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    // Configurado para escutar apenas a partição 0
    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "${kafka.topic-name}", partitions = {"0"})
            },
            containerFactory = "strContainerFactory")
    public void listener1(String message) {
        log.info("[listener 1] Mensagem recebida: {}", message);
    }

    // Configurado para escutar apenas a partição 1
    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "${kafka.topic-name}", partitions = {"1"})
            },
            containerFactory = "strContainerFactory")
    public void listener2(String message) {
        log.info("[listener 2] Mensagem recebida: {}", message);
    }

    // Configurado para escutar as partições 0 e 1
    @KafkaListener(groupId = "group-2", topics = "${kafka.topic-name}", containerFactory = "strContainerFactory")
    public void listener3(String message) {
        log.info("[listener 3] Mensagem recebida: {}", message);
    }

}
