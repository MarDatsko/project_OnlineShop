package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;
}
