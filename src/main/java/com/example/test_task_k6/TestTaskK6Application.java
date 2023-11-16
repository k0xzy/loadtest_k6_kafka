package com.example.test_task_k6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class TestTaskK6Application {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskK6Application.class, args);
    }
}

@RestController
class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public UserController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-to-kafka")
    public String sendToKafka(@RequestBody String userId) {
        if (userId == null || userId.isEmpty()) {
            userId = UUID.randomUUID().toString();
        }

        kafkaTemplate.send("user-topic", userId);
        return "Message sent to Kafka: " + userId;
    }
}