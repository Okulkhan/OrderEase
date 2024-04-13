package com.acceptingOrders.Ozon.dto;

import com.acceptingOrders.Ozon.model.Order;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {
    private ModelMapper modelMapper;

    public OrderDto convertToDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public Order convertToEntity(OrderDto orderDto){
        return modelMapper.map(orderDto, Order.class);
    }
}
