package com.job.Portal.Dto;

import lombok.Data;

@Data
public class UserResponseDto {
    //outcoming data
    private long id;

    private String name;

    private String email;

    private String role;

    //password private
}
