package com.Student.Management.SMS.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String stuid;
   private String firstname;
   private String lastname;
   private String nic;
   private String address1;
   private String address2;
   private String city;
   private Long mobile;
   private String email;
   private String contactperson;
   private Long phone;


}
