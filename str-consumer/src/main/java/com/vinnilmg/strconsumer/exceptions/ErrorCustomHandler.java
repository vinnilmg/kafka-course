package com.vinnilmg.strconsumer.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("EXCEPTION_HANDLER ::: Erro capturado.");
        log.info("Payload: {}", message.getPayload());
        log.info("Headers: {}", message.getHeaders());
        log.info("Offset: {}", message.getHeaders().get("kafka_offset"));
        log.info("Partition: {}", message.getHeaders().get("kafka_receivedPartitionId"));
        log.info("GroupId: {}", message.getHeaders().get("kafka_groupId"));
        log.info("ExceptionMessage: {}", e.getMessage());
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
