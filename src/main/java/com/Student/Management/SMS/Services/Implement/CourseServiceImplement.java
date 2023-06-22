package com.Student.Management.SMS.Services.Implement;

import com.Student.Management.SMS.Entity.Course;
import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.Repository.CourseRepository;
import com.Student.Management.SMS.Repository.StudentRepository;
import com.Student.Management.SMS.RequestDTO.CourseRequest;
import com.Student.Management.SMS.Services.CourseServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplement implements CourseServices
{
    @Autowired
    private CourseRepository courseRepository;



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


}
