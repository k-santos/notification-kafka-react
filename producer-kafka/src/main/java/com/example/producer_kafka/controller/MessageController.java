package com.example.producer_kafka.controller;


import com.example.producer_kafka.notification.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private NotificationProducer notificationProducer;

    @PostMapping("admin/send")
    public void sendMessageAdmin(@RequestParam String message) {
        notificationProducer.sendMessage("notification_adm", message);
    }

    @PostMapping("default/send")
    public void sendMessageDefault(@RequestParam String message) {
        notificationProducer.sendMessage("notification_default", message);
    }
}