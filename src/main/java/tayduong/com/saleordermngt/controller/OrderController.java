package tayduong.com.saleordermngt.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tayduong.com.saleordermngt.config.KafkaTopics;
import tayduong.com.saleordermngt.entities.Order;
import tayduong.com.saleordermngt.repo.CustomerRepository;
import tayduong.com.saleordermngt.repo.OrderPolicyRepository;
import tayduong.com.saleordermngt.repo.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderPolicyRepository orderPolicyRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository, OrderPolicyRepository orderPolicyRepository, @Qualifier("kafkaTemplate") KafkaTemplate kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderPolicyRepository = orderPolicyRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    @ResponseBody
    public List<?> getOrders() {

        kafkaTemplate.send(KafkaTopics.NOTIFICATION, orderRepository.findAll());

        return orderRepository.findAll();
    }
}
