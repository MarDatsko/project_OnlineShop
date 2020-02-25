package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class AccountDto {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;
}
