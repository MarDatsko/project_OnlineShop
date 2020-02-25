package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "order_price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany
    @JoinTable(name = "order_orderItem",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<OrderItem> itemList;
}
