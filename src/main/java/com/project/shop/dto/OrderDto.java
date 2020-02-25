package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDto {

    private Long id;
    private Long orderNumber;
    private Date date;
    private BigDecimal price;
    private Long userId;
    private List<OrderItemDto> itemDtoList;
}
