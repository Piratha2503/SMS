package com.Student.Management.SMS.Entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserLogs
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String otp;
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String otpStatus;


}
