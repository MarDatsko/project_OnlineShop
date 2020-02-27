package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class PositionDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean availability;
    private Integer stock;
    private List<CategoryDto> categoryDtoList;
    private Long userId;
}
