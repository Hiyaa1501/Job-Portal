package com.job.Portal.Dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String role;
}
