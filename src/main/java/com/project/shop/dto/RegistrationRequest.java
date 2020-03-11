package com.project.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
}
