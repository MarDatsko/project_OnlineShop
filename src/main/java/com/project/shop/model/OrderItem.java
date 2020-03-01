package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_item")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "item_price")
    @DecimalMin(value = "0.00")
    private BigDecimal price;

}
