package com.Student.Management.SMS.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter


public class Course
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String coursename;
  private String category;


  /*
  @ManyToMany
  @JoinColumn(name = "student_id")
  private List<Student> students;

   */

}
