package com.example.consumer_kafka.notification;
import com.example.consumer_kafka.websocket.NotificationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationController notificationController;
    @KafkaListener(topics = "notification_adm")
    public void listenAdm(String message) throws IOException {
        notificationController.sendNotificationAdm(message);
    }

    @KafkaListener(topics = "notification_default")
    public void listenDefault(String message) throws IOException {
        notificationController.sendNotificationDefault(message);
    }
}