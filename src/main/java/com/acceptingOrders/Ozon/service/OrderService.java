package com.acceptingOrders.Ozon.service;

import com.acceptingOrders.Ozon.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDto creatingAnOrder(OrderDto Dto);

    List<OrderDto> getAll();

    void notifyOrderEmail(Long orderId, String recipientEmail);
}
