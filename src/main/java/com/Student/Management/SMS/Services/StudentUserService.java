package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.RequestDTO.StudentUserRequest;

public interface StudentUserService
{

    boolean studentLogin(StudentUserRequest studentUserRequest);

    boolean existsByEmail(String email);

    String passwordReset(String email);
}
