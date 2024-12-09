package com.java.lld.exammanagement.repo.impl;

import com.java.lld.exammanagement.entity.Student;
import com.java.lld.exammanagement.repo.StudentDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@Setter
public class StudentDbImpl implements StudentDb {

    private Map<String, Student> studentMap;

    @Override
    public Student createStudent(Student student) {

        if (this.studentMap.containsKey(student.getStudentId())) {
            System.out.println("Student already exists");
        } else {
            this.studentMap.put(student.getStudentId(), student);
        }

        return student;
    }

    @Override
    public Student getStudent(String studentId) {

        if (this.studentMap.containsKey(studentId)) {
            return this.studentMap.get(studentId);
        } else {
            System.out.println("Student does not exists!");
            return null;
        }
    }
}