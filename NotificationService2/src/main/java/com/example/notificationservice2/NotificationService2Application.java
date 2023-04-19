package com.example.notificationservice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationService2Application {

    public static void main(String[] args) {
        SpringApplication.run(NotificationService2Application.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("receive notification  {}" , orderPlacedEvent.getOrderNumber());
    }

}
