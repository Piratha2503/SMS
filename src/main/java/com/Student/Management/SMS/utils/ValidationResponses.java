package com.Student.Management.SMS.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:vallidations.properties")
@Getter
@Setter
public class ValidationResponses
{
    // Common Codes
    @Value("${common.success.code}")
    private String commonSuccessCode;
    @Value("${common.failure.code}")
    private String commonFailureCode;

    // CRUD Operations Message
    @Value("${message.insert.student}")
    private String insertMsg;
    @Value("${message.update.student}")
    private String updateMsg;
    @Value("${message.delete.student}")
    private String deleteMsg;
    @Value("${message.viewall.student}")
    private String viewAllMsg;

    @Value("${message.nic.notfound}")
    private String NicNotFoundMsg;
    @Value("${message.StuID.notfound}")
    private String STUIDNotFoundMsg;
    @Value("${message.nic.alreadyExist}")
    private String NicAlreadyExist;

    /*
    *
    *
common.success.code = 1000
common.failure.code = 2000

message.nic.notfound = NIC Not Found
message.StuID.notfound = STU ID Not Found
message.nic.alreadyExist = Nic Already Exist
message.insert.student = Student Details Successfully Inserted
message.update.student = Student Details Successfully Updated
message.delete.student = Student Details Successfully Deleted
message.viewall.student = Student Details View
*/


}
