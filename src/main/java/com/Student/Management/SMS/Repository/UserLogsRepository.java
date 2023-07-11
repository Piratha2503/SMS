package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.UserLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogsRepository extends JpaRepository<UserLogs,Long>
{
    UserLogs findByUserNameIgnoreCaseAndOtpIgnoreCase(String userName, String otp);

    boolean existsByOtp(String otp);
}
