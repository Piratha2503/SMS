package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentUserRepository extends JpaRepository<StudentUser,Long>
{

}
