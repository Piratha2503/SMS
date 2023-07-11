package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.RequestDTO.EmailRequest;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;

public interface StudentUserServices {
    void userSignUp(StudentUserRequest studentUserRequest);
    void sendMail(EmailRequest emailRequest);

    boolean existEmail(String email);
    boolean existUserName(String userName);

    void userAuthorize(StudentUserRequest studentUserRequest);

    boolean existOTP(String otp);
}
