package com.Student.Management.SMS.RequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest
{
    String userName;
    String to;
    String subject;
    String text;
}
