package com.Student.Management.SMS.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse
{

    private Long id;
    private String stuid;
    private String firstname;
    private String lastname;
    private String nic;
    private String address1;
    private String address2;
    private String city;
    private Long mobile;
    private String email;
    private String contactperson;
    private Long phone;
}
