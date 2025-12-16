
package com.example.order.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.order.repo.OrderRepository;
import com.example.order.model.Order;
import com.example.order.kafka.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;
    private final OrderProducer producer;

    public OrderController(OrderRepository repo, OrderProducer producer) {
        this.repo = repo;
        this.producer = producer;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        Order saved = repo.save(order);
        producer.sendOrderEvent("Order Created: " + saved.getId());
        return saved;
    }

    @GetMapping
    public List<Order> getAll() {
        return repo.findAll();
    }
}
