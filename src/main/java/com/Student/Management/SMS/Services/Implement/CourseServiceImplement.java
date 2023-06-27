package com.Student.Management.SMS.Services.Implement;

import com.Student.Management.SMS.Entity.Course;
import com.Student.Management.SMS.Repository.CourseRepository;
import com.Student.Management.SMS.ResponseDTO.CourseResponse;
import com.Student.Management.SMS.Services.CourseServices;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CourseServiceImplement implements CourseServices
{
    @Autowired
    private CourseRepository courseRepository;

    public void insertCourse(CourseResponse courseResponse)
    {
        Course course = new Course();
        BeanUtils.copyProperties(courseResponse,course);
        courseRepository.save(course);

    }


}



    /*

    @Autowired
    private StudentRepository studentRepository;
   @Override
    public void insertCourse(CourseRequest courseRequest)
    {
        List<Student> studentList = new ArrayList<>();
        Course course = new Course();
        Long myid = courseRequest.getId();
        Student student = studentRepository.findById(myid).get();
        studentList.add(student);
        course.setStudents(studentList);
        BeanUtils.copyProperties(courseRequest,course);
        courseRepository.save(course);
    }
    @Override
    public Course getByCourseId(Long id)
    {
     Course courses = courseRepository.findById(id).get();
     return courses;
    }
    */



