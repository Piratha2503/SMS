package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.Entity.StudentUser;
import com.Student.Management.SMS.RequestDTO.EmailRequest;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;
import com.Student.Management.SMS.Services.StudentUserServices;

import com.Student.Management.SMS.utils.Emailconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private Emailconfig emailconfig;

    @PostMapping("/usersignup")
    public ResponseEntity<Object> userSignUp(@RequestBody StudentUserRequest studentUserRequest)
    {
        if (studentUserServices.existEmail(studentUserRequest.getEmail()))
            return ResponseEntity.ok("Email AlreadyExist");
        if (studentUserServices.existUserName(studentUserRequest.getUserName()))
            return ResponseEntity.ok("User Name AlreadyExist");
        studentUserServices.userSignUp(studentUserRequest);
        return ResponseEntity.ok("Success fully Registered and OTP forwarded to relevant Mail Id");
    }

    @PostMapping("/userAuth")
    public String userAuthorize(@RequestBody StudentUserRequest studentUserRequest)
    {
        if (!studentUserServices.existUserName(studentUserRequest.getUserName()) || !studentUserServices.existOTP(studentUserRequest.getOtp()) )
            return "User Name / OTP Invalid";
        studentUserServices.userAuthorize(studentUserRequest);
        return "User Verified";
    }




}
