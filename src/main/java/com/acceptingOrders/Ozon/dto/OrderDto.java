package com.acceptingOrders.Ozon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String fullName;
    private String recipientCity;
    private String recipientAddress;
    private String recipientEmail;
    private String senderCity;
    private String senderAddress;
    private String weight;
    private LocalDate date;
}
