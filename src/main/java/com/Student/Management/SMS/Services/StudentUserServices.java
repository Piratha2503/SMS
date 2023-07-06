package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.Entity.StudentUser;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;

public interface StudentUserServices {
    public StudentUser userSignUp(StudentUserRequest studentUserRequest);
}
