package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class PositionDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Long availability;
    private Long categoryId;
    private Long userId;
}
