package com.java.lld.exammanagement.service.impl;

import com.java.lld.exammanagement.entity.CompletionMeta;
import com.java.lld.exammanagement.entity.Exam;
import com.java.lld.exammanagement.repo.ExamDb;
import com.java.lld.exammanagement.repo.GroupDb;
import com.java.lld.exammanagement.repo.ResultDb;
import com.java.lld.exammanagement.repo.StudentDb;
import com.java.lld.exammanagement.service.ExamManagementService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ExamManagementServiceImpl implements ExamManagementService {

    private ExamDb examDb;
    private GroupDb groupDb;
    private ResultDb resultDb;
    private StudentDb studentDb;

    @Override
    public Exam createExam(Exam exam) {
        return this.examDb.createExam(exam);
    }

    @Override
    public List<Exam> getUpcomingExams() {
        return this.examDb.getUpcomingExams();
    }

    @Override
    public void sendExamStartNotification() {

    }

    @Override
    public void submitExam(String studentId, CompletionMeta completionMeta) {
        this.resultDb.registerExamCompletion(studentId, completionMeta);
    }
}
