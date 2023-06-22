package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student,Long>
{
    public boolean existsByNic(String nic);
    public List<Student> findAllByNic(String nic);
    public boolean existsByStuid(String stuid);
    public List<Student> findAllByStuid(String stuid);
}
