package com.java.lld.exammanagement.repo;

import com.java.lld.exammanagement.entity.Exam;
import com.java.lld.exammanagement.entity.Schedule;

import java.util.List;

public interface ExamDb {

    Exam createExam(Exam exam);
    Exam getExam(String examId);
    List<Exam> getUpcomingExams();
}
