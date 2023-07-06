package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.Entity.StudentUser;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;
import com.Student.Management.SMS.Services.StudentUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentUserController
{
    @Autowired
    private StudentUserServices studentUserServices;

    @PostMapping("/usersignup")
    public StudentUser userSignUp(@RequestBody StudentUserRequest studentUserRequest)
    {
        return studentUserServices.userSignUp(studentUserRequest);
    }
}
