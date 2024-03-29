package com.example.springbootthymeleaf.config;

import com.example.springbootthymeleaf.model.websocket.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {
    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 5000)
    public void sendAdhocMessages() {
        System.out.println("New message to broker");
        template.convertAndSend("/topic/greetings",
                new UserResponse("Scheduler"));
    }
}
