package com.java.lld.exammanagement.repo.impl;

import com.java.lld.exammanagement.entity.Exam;
import com.java.lld.exammanagement.repo.ExamDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class ExamDbImpl implements ExamDb {

    private Map<String, Exam> examDbMap;

    @Override
    public Exam createExam(Exam exam) {

        if (this.examDbMap.containsKey(exam.getExamId())) {
            System.out.println("Exam already present!");

        } else {
            System.out.println("Exam created!");
            this.examDbMap.put(exam.getExamId(), exam);
        }

        return this.examDbMap.get(exam.getExamId());
    }

    @Override
    public Exam getExam(String examId) {

        if (this.examDbMap.containsKey(examId)) {
            return this.examDbMap.get(examId);

        } else {

            System.out.println("Exam not present!");
            return null;
        }
    }

    @Override
    public List<Exam> getUpcomingExams() {

        List<Exam> exams;

        if (!this.examDbMap.isEmpty()) {
            exams = new ArrayList<>(this.examDbMap.values());
        } else {

            System.out.println("No exams available!");
            return null;
        }

        return exams;
    }
}