package com.Student.Management.SMS.Services.Implement;

import com.Student.Management.SMS.Entity.StudentUser;
import com.Student.Management.SMS.Repository.StudentUserRepository;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;
import com.Student.Management.SMS.Services.StudentUserServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentUserServiceImplement implements StudentUserServices
{
    @Autowired
    private StudentUserRepository studentUserRepository;

    @Override
    public StudentUser userSignUp(StudentUserRequest studentUserRequest)
    {
        StudentUser studentUser = new StudentUser();
        BeanUtils.copyProperties(studentUserRequest,studentUser);
        return studentUserRepository.save(studentUser);
    }
}
