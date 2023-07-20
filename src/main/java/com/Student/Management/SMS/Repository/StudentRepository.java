package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>
{
    public boolean existsByNic(String nic);
    public List<Student> findAllByNic(String nic);
    public boolean existsByStuid(String stuid);
    public List<Student> findAllByStuid(String stuid);
    List<Student> findAllByCityIgnoreCaseNot(String city);

    void deleteAllByNic(String nic);

    void deleteByNic(String nic);
}
