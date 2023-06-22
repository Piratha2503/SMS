package com.Student.Management.SMS.ResponseDTO;

import com.Student.Management.SMS.Entity.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Getter
@Setter
public class CourseResponse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coursename;
    private String category;


}