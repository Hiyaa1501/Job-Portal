package com.job.Portal.Dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;

    private Long id;

    private String name;

    private String email;

    private String role;
}
