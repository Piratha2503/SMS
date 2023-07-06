package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourseController
{

    @Autowired
    private CourseServices courseServices;


}



