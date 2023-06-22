package es.viferpar.kafka.publisher.infrastructure.adapters.api.controllers;

import es.viferpar.kafka.publisher.domain.Notification;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(
        value = "/api/v1/kafka-publisher",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class PublishMessageController {

    private final StreamBridge streamBridge;

    @GetMapping("/publish")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void publishMessage() {
        final var notification = Notification.builder()
                .team("seller-ops")
                .dataType("toolbox-advanced-analytics")
                .uploadedAt(LocalDateTime.now())
                .toolboxAnalyticsResultsS3Path("s3://int-ms-seller-analytics-cooker-analytics-data-eu-west-3/advanced_analytics_toolbox/2023/02/14")
                .build();

        streamBridge.send("producer-out-0", notification);
    }
}
