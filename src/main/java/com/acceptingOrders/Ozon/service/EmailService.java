package com.acceptingOrders.Ozon.service;

import com.acceptingOrders.Ozon.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendOrderEmail(Order order, String recipientEmail);
}
