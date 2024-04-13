package com.acceptingOrders.Ozon.service;

import com.acceptingOrders.Ozon.dto.OrderDto;
import com.acceptingOrders.Ozon.dto.OrderMapper;
import com.acceptingOrders.Ozon.model.Order;
import com.acceptingOrders.Ozon.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final EmailService emailService;

    @Override
    public OrderDto creatingAnOrder(OrderDto Dto) {
        Order order = orderMapper.convertToEntity(Dto);
        order.setOrderNumber(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return orderMapper.convertToDto(orderRepository.save(order));
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> ordelList = orderRepository.findAll();
        List<OrderDto> orderDto = new ArrayList<>();

        for (Order order : ordelList) {
            orderDto.add(orderMapper.convertToDto(order));
        }
        return orderDto;
    }

    @Override
    public void notifyOrderEmail(Long orderId, String recipientEmail) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Заказ с id " + orderId + " не найден"));

        emailService.sendOrderEmail(order, recipientEmail);
    }
}
