package com.project.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
