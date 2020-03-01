package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryDto {

    private Long id;
    private String description;
    private String imagePath;
    private Long userId;
}
