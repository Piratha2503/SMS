package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.Entity.Course;
import com.Student.Management.SMS.RequestDTO.CourseRequest;
import com.Student.Management.SMS.ResponseDTO.CourseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseServices
{
    public void insertCourse(CourseResponse courseResponse);
    //public String fileUpload(MultipartFile file);
    /*
    public void insertCourse(CourseRequest courseRequest);
    public Course getByCourseId(Long id);
*/
}
