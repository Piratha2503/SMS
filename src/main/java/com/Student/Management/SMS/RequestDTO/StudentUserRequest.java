package com.Student.Management.SMS.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentUserRequest
{
    private String userName;
    private String password;
    private String email;
    private LocalDateTime createdAt = LocalDateTime.now();

}
