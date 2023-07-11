package com.Student.Management.SMS.PasswordReset;

import com.Student.Management.SMS.utils.Emailconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


public class SendEmail
{
  @Autowired
  private Emailconfig emailconfig;

  private JavaMailSender mailSender;




  public SendEmail(SimpleMailMessage mailMessage)
  {
      JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
      javaMailSender.setHost("smtp.gmail.com");
      javaMailSender.setPort(587);
      javaMailSender.setUsername("pirathaban1992@gmail.com");
      javaMailSender.setPassword("sulalhuaqkfffgmg");

      Properties properties = javaMailSender.getJavaMailProperties();
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.transport.protocol", "smtp");

      this.mailSender = javaMailSender;

      mailSender.send(mailMessage);


  }

}
