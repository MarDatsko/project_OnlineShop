package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_name")
    private String name;

    @Column(name = "price")
    @DecimalMin(value = "0.00")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "stock")
    private Integer stock;
     // 1 positio may belong to multiple category? looks weird
    @ManyToOne
    @JoinTable(
            name="position_category",
            joinColumns = @JoinColumn(name="position_id"),
            inverseJoinColumns = @JoinColumn(name="category_Id")
    )
    private Category category;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User userId;
}