package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.RequestDTO.EmailRequest;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;

public interface StudentUserServices {
    public void userSignUp(StudentUserRequest studentUserRequest);
    public void sendMail(EmailRequest emailRequest);

    public boolean existEmail(String email);
    public boolean existUserName(String userName);

    void userAuthorize(StudentUserRequest studentUserRequest);

    boolean existOTP(String otp);
}
