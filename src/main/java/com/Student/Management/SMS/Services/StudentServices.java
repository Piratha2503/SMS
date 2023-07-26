package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import com.Student.Management.SMS.ResponseDTO.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentServices
{
    // Check Functions
    public boolean isExistByNic(String nic);
    public boolean isExistByStuid(String stuid);
    boolean existById(Long id);

    // Search Operations
    public List<Student> findByNic(String nic);
    public List<Student> findByStuid(String stuid);

    // Pagination
    public Page<Student> getALlPage(Pageable pageable);

    // CRUD Operations
    public void insertSudents(StudentRequest studentRequest);
    public void updateStudent(StudentRequest studentRequest);
    public String deleteStudent(Long id);
    public List<Student> getAllStudents();

    List<StudentResponse> getStudentsByCity(String city);

    List<StudentResponse> getStudents();

    StudentResponse getStudentById(Long id);
}
