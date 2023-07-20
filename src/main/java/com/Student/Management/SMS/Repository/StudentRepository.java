package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>
{
    boolean existsByNic(String nic);
    List<Student> findAllByNic(String nic);
    boolean existsByStuid(String stuid);
    List<Student> findAllByStuid(String stuid);
    List<Student> findAllByCityIgnoreCaseNot(String city);

    void deleteAllByNic(String nic);

    void deleteByNic(String nic);
}
