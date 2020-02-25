package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordersItem")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
                                //Have some question
   // @Column(name = "positionId")
   // private Position position;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "item_price")
    private BigDecimal price;

}
