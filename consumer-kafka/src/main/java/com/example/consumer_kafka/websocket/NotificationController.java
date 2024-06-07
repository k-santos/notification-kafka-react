package com.example.consumer_kafka.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendNotificationAdm(String message) {
        this.template.convertAndSend("/topic/notifications/adm", message);
    }

    public void sendNotificationDefault(String message) {
        this.template.convertAndSend("/topic/notifications/default", message);
    }
}