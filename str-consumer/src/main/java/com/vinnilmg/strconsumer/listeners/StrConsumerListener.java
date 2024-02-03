package com.vinnilmg.strconsumer.listeners;

import com.vinnilmg.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener1(String message) {
        log.info("[listener 1] Mensagem recebida: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener2(String message) {
        log.info("[listener 2] Mensagem recebida: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-2")
    public void listener3(String message) {
        log.info("[listener 3] Mensagem recebida: {}", message);
    }

}
