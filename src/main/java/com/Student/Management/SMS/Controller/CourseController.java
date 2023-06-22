package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.Entity.Course;
import com.Student.Management.SMS.RequestDTO.CourseRequest;
import com.Student.Management.SMS.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController
{
    /*
    @Autowired
    private CourseServices courseServices;

    @PostMapping("/insertCourse")
    public void insert(@RequestBody CourseRequest courseRequest)
    {
        courseServices.insertCourse(courseRequest);
    }
    @GetMapping("/getByCID/{id}")
    public Course getById(@PathVariable Long id)
    {
        return courseServices.getByCourseId(id);
    }

     */
}
