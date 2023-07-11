package com.Student.Management.SMS.RequestDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentUserRequest
{
    private String userName;
    private String password;
    private String email;
    private String otp;

}
