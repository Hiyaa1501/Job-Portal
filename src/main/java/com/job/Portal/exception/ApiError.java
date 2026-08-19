package com.job.Portal.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String message;
}

//{
//    "timestamp": "2026-08-19T23:10:00",
//    "status": 404,
//    "message": "Job not found with id: 10"
//}
