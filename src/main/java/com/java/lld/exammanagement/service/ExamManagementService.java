package com.java.lld.exammanagement.service;

import com.java.lld.exammanagement.entity.CompletionMeta;
import com.java.lld.exammanagement.entity.Exam;

import java.util.List;

public interface ExamManagementService {

    Exam createExam(Exam exam);
    List<Exam> getUpcomingExams();
    void sendExamStartNotification();
    void submitExam(String studentId, CompletionMeta completionMeta);
}
