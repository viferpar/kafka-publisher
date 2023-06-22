package es.viferpar.kafka.publisher.infrastructure.adapters.client.cloud.producer;

import es.viferpar.kafka.publisher.domain.Notification;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class MessageProducer {

    @Bean
    public Supplier<Notification> producer() {
        return () -> null;
    }

}
