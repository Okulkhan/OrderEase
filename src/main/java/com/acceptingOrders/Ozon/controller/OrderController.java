package com.acceptingOrders.Ozon.controller;

import com.acceptingOrders.Ozon.dto.OrderDto;
import com.acceptingOrders.Ozon.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/creating")
    public OrderDto creatingAnOrder(@RequestBody OrderDto order) {
        return orderService.creatingAnOrder(order);
    }

    @GetMapping("/get")
    public List<OrderDto> getPrograms() {
        return orderService.getAll();
    }

    @PostMapping("/{orderId}/email")
    public void notifyOrderEmail(@PathVariable Long orderId, @RequestParam String recipientEmail) {
        orderService.notifyOrderEmail(orderId, recipientEmail);
    }
}
