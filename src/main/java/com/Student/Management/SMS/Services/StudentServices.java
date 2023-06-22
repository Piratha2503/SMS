package com.Student.Management.SMS.Services;

import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface StudentServices
{
    // Check Functions
    public boolean isExistByNic(String nic);
    public boolean isExistByStuid(String stuid);

    // Search Operations
    public List<Student> findByNic(String nic);
    public List<Student> findByStuid(String stuid);

    // Pagination
    public Page<Student> getALlPage(Pageable pageable);

    // CRUD Operations
    public void insertSudents(StudentRequest studentRequest);
    public void updateStudent(StudentRequest studentRequest);
    public String deleteStudent(String nic);
    public List<Student> getAllStudents();


}
