package com.java.lld.exammanagement.repo;

import com.java.lld.exammanagement.entity.Student;

public interface StudentDb {
    Student createStudent(Student student);
    Student getStudent(String studentId);
}