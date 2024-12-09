package com.java.lld.exammanagement;

import com.java.lld.exammanagement.entity.*;
import com.java.lld.exammanagement.repo.ExamDb;
import com.java.lld.exammanagement.repo.GroupDb;
import com.java.lld.exammanagement.repo.ResultDb;
import com.java.lld.exammanagement.repo.StudentDb;
import com.java.lld.exammanagement.repo.impl.ExamDbImpl;
import com.java.lld.exammanagement.repo.impl.GroupDbImpl;
import com.java.lld.exammanagement.repo.impl.ResultDbImpl;
import com.java.lld.exammanagement.repo.impl.StudentDbImpl;
import com.java.lld.exammanagement.service.ExamManagementService;
import com.java.lld.exammanagement.service.impl.ExamManagementServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Student s1 = Student.builder().studentName("Sharad").studentId("111").build();
        Student s2 = Student.builder().studentName("Anurag").studentId("112").build();
        List<String> g1Students = new ArrayList<>();
        g1Students.add("111");
        g1Students.add("112");
        Group g1 = Group.builder().groupId("g1").students(g1Students).build();

        Student s3 = Student.builder().studentName("Puneet").studentId("113").build();
        Student s4 = Student.builder().studentName("Udit").studentId("114").build();
        List<String> g2Students = new ArrayList<>();
        g2Students.add("113");
        g2Students.add("114");
        Group g2 = Group.builder().groupId("g2").students(g2Students).build();


        Schedule sch1 = Schedule.builder().startDateTime("2").endDateTime("6").timezone("xxx").build();
        Exam e1 = Exam.builder().examId("123").examTitle("TOC").schedule(sch1).build();

        Schedule sch2 = Schedule.builder().startDateTime("2").endDateTime("6").timezone("xxx").build();
        Exam e2 = Exam.builder().examId("124").examTitle("OOP").schedule(sch2).build();

        Schedule sch3 = Schedule.builder().startDateTime("2").endDateTime("6").timezone("xxx").build();
        Exam e3 = Exam.builder().examId("125").examTitle("Java").schedule(sch3).build();

        ExamDb examDb = ExamDbImpl.builder().examDbMap(new HashMap<>()).build();
        GroupDb groupDb = GroupDbImpl.builder().groupDbMap(new HashMap<>()).build();
        ResultDb resultDb = ResultDbImpl.builder().resultDbMap(new HashMap<>()).build();
        StudentDb studentDb = StudentDbImpl.builder().studentMap(new HashMap<>()).build();

        ExamManagementService service = ExamManagementServiceImpl.builder().examDb(examDb)
                .groupDb(groupDb).resultDb(resultDb).studentDb(studentDb).build();

        service.createExam(e1);
        service.createExam(e2);
        service.createExam(e3);

        for (Exam exam : service.getUpcomingExams()) {
            System.out.printf("Upcoming Exam: %s%n", exam.getExamTitle());
        }

        CompletionMeta completionMeta = CompletionMeta.builder().completionMetaId("123").examId("123").startDateTime("2").endDateTime("3").score(87.0).submit(true).build();
        service.submitExam(s1.getStudentId(), completionMeta);

        System.out.println("Debug!");
    }
}
