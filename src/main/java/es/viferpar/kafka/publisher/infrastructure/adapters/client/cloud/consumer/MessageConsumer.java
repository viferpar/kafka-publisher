package es.viferpar.kafka.publisher.infrastructure.adapters.client.cloud.consumer;

import es.viferpar.kafka.publisher.domain.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class MessageConsumer {
    @Bean
    public Consumer<Notification> consumer() {
        return event -> log.info(event.toString());
    }
}
