package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.APIResponse.BaseResponse;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;
import com.Student.Management.SMS.RestEnum.ResponseStatus;
import com.Student.Management.SMS.Services.StudentUserService;
import com.Student.Management.SMS.Services.UserLogsService;
import com.Student.Management.SMS.utils.ValidationResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentUserController
{
    @Autowired
    private StudentUserService studentUserService;
    @Autowired
    private ValidationResponses validationResponses;
    @Autowired
    private UserLogsService userLogsService;

    @PostMapping("/studentLogin")
    public ResponseEntity<Object> studentLogin(@RequestBody StudentUserRequest studentUserRequest)
    {
        if (studentUserService.studentLogin(studentUserRequest)) {
            return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonSuccessCode(), ResponseStatus.SUCCESS.getStatus(),validationResponses.getLoginSuccessMessage()));
        } else {
            return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(), ResponseStatus.FAILURE.getStatus(),validationResponses.getLoginFailureMessage()));
        } }

    @PostMapping("/sendLink")
    public ResponseEntity<Object> sendLink(@RequestBody StudentUserRequest studentUserRequest)
    {
        if (!studentUserService.existsByEmail(studentUserRequest.getEmail()))
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(),ResponseStatus.ERROR.getStatus(), validationResponses.getEmailNotFoundMessage()));
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonSuccessCode(), ResponseStatus.SUCCESS.getStatus(), studentUserService.passwordReset(studentUserRequest.getEmail())));
    }

    @GetMapping("/sendLink/{token}")
    public ResponseEntity<Object> checkLink(@PathVariable String token)
    {
        if (userLogsService.existsByToken(token))
            return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonSuccessCode(),ResponseStatus.SUCCESS.getStatus(),validationResponses.getUserVerifiedMessage()));
       else return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(), ResponseStatus.FAILURE.getStatus(), HttpStatus.BAD_REQUEST.toString()));
    }



}
