package com.vinnilmg.strproducer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {

    public final KafkaProperties properties;

    @Value("${kafka.topic-name}")
    private String topicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        log.info("Iniciando configuração do kafka: {}", properties.getBootstrapServers());
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics topics() {
        // Cria o tópico
        return new KafkaAdmin.NewTopics(
                TopicBuilder
                        .name(topicName)
                        .partitions(2)
                        .replicas(1)
                        .build()
        );
    }

}
