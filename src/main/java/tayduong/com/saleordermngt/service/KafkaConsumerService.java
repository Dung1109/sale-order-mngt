package tayduong.com.saleordermngt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import tayduong.com.saleordermngt.config.KafkaTopics;
import tayduong.com.saleordermngt.entities.Order;

import java.util.List;

@Service
public class KafkaConsumerService {

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @KafkaListener(topics = KafkaTopics.NOTIFICATION, groupId = "tayduong-order-system", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload List<Order> message) {
        System.out.println("Consumed message: " + message.toString());
    }
}