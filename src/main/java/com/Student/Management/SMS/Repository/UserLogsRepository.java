package com.Student.Management.SMS.Repository;

import com.Student.Management.SMS.Entity.UserLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface UserLogsRepository extends JpaRepository<UserLogs,Long>
{
    UserLogs findByUserNameIgnoreCaseAndOtpIgnoreCase(String userName, String otp);

    @Query("SELECT MAX(u.updatedAt) FROM UserLogs u WHERE u.otp = :otp")
    LocalDateTime findMaxUpdatedAtByOtp(@Param("otp") String otp);

    boolean existsByOtpAndUpdatedAt(String otp, LocalDateTime dateTime);
}
