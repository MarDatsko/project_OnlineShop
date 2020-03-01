package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItemDto {

    private Long id;
    private String name;
    private Long quantity;
    private BigDecimal price;
}
