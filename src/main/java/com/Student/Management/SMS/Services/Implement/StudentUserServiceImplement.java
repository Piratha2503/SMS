package com.Student.Management.SMS.Services.Implement;

import com.Student.Management.SMS.Entity.StudentUser;
import com.Student.Management.SMS.Entity.UserLogs;
import com.Student.Management.SMS.PasswordReset.OtpGenerate;
import com.Student.Management.SMS.PasswordReset.SendEmail;
import com.Student.Management.SMS.PasswordReset.generateToken;
import com.Student.Management.SMS.Repository.StudentUserRepository;
import com.Student.Management.SMS.Repository.UserLogsRepository;
import com.Student.Management.SMS.RequestDTO.EmailRequest;
import com.Student.Management.SMS.RequestDTO.StudentUserRequest;
import com.Student.Management.SMS.Services.StudentUserServices;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class StudentUserServiceImplement implements StudentUserServices {
    @Autowired
    private StudentUserRepository studentUserRepository;

    @Autowired
    private generateToken generateToken;

    @Autowired
    private UserLogsRepository userLogsRepository;

    @Override
    public void userSignUp(StudentUserRequest studentUserRequest)
    {
        StudentUser studentUser = new StudentUser();
        BeanUtils.copyProperties(studentUserRequest, studentUser);
        studentUserRepository.save(studentUser);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setUserName(studentUserRequest.getUserName());
        emailRequest.setTo(studentUserRequest.getEmail());
        emailRequest.setSubject("Register Email");
        generateMail(emailRequest);

    }
    @Override
    public void generateMail(EmailRequest emailRequest)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        UserLogs userLogs = new UserLogs();
        OtpGenerate otpGenerate = new OtpGenerate();
        mailMessage.setTo(emailRequest.getTo());
        mailMessage.setSubject(emailRequest.getSubject());
        mailMessage.setText("This is Your OTP" + otpGenerate.getOtp());
        new SendEmail(mailMessage);
        userLogs.setUserName(emailRequest.getUserName());
        userLogs.setOtp(otpGenerate.getOtp());
        userLogs.setOtpStatus("New");
        userLogsRepository.save(userLogs);

    }

    @Override
    public boolean existEmail(String email)
    {
        return studentUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existUserName(String userName)
    {
        return studentUserRepository.existsByUserName(userName);
    }

    @Override
    public void userAuthorize(StudentUserRequest studentUserRequest)
    {
        StudentUser authStudentUser = studentUserRepository.findByUserNameIgnoreCaseAndEmailIgnoreCase(studentUserRequest.getUserName(),studentUserRequest.getEmail());
        authStudentUser.setActivate(true);
        studentUserRepository.save(authStudentUser);

        UserLogs authuserLogs = userLogsRepository.findByUserNameIgnoreCaseAndOtpIgnoreCase(studentUserRequest.getUserName(),studentUserRequest.getOtp());
        authuserLogs.setOtpStatus("Verified");
        userLogsRepository.save(authuserLogs);

    }

    @Override
    public boolean existOTP(String otp)
    {
        LocalDateTime dateTime = userLogsRepository.findMaxUpdatedAtByOtp(otp);
        return userLogsRepository.existsByOtpAndUpdatedAt(otp,dateTime);
    }

}
