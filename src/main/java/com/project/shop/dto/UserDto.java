package com.project.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String role;
    private String userStatus;
    private Long accountId;
}
