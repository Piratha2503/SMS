package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long>
{
    public List<Course> findByCoursename(String courseName);
}
