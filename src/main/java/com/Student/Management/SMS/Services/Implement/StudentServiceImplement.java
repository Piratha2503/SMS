package com.Student.Management.SMS.Services.Implement;


import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.Repository.StudentRepository;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import com.Student.Management.SMS.ResponseDTO.StudentResponse;
import com.Student.Management.SMS.Services.StudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentServices
{
    @Autowired
    private StudentRepository studentRepository;

    // Check Functions
    @Override
    public boolean isExistByNic(String nic)
    {
        return studentRepository.existsByNic(nic);
    }
    @Override
    public boolean isExistByStuid(String stuid) {return studentRepository.existsByStuid(stuid);}

    // Search Functions
    @Override
    public List<Student> findByNic(String nic)
    {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAllByNic(nic).forEach(student1 -> studentList.add(student1));
        return studentList;
    }

    public List<Student> findByStuid(String stuid)
    {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAllByStuid(stuid).forEach(student -> studentList.add(student));
        return studentList;
    }

    //Pagination
    public Page<Student> getALlPage(Pageable pageable)
    {
       Page<Student> studentPage = studentRepository.findAll(pageable);
       return studentPage;
    }
    // CRUD Operations
    @Override
    public void insertSudents(StudentRequest studentRequest)
    {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest,student);
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(StudentRequest studentRequest)
    {
        Student students = studentRepository.findById(studentRequest.getId()).get();
        BeanUtils.copyProperties(studentRequest,students);
        studentRepository.save(students);
    }

    @Transactional
    @Override
    public String deleteStudent(String nic)
    {
        studentRepository.deleteByNic(nic);
        return "ok";
    }

    @Override
    public List<Student> getAllStudents()
    {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(student -> studentList.add(student));
        return studentList;
    }

    @Override
    public List<StudentResponse> getStudentsByCity(String city)
    {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllByCityIgnoreCaseNot(city);
        for (Student student : studentList)
        {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student,studentResponse);
            studentResponseList.add(studentResponse);
        }
            return studentResponseList;
    }
}
