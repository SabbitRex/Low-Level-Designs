package com.java.lld.exammanagement.repo.impl;

import com.java.lld.exammanagement.entity.CompletionMeta;
import com.java.lld.exammanagement.repo.ResultDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@Setter
public class ResultDbImpl implements ResultDb {

    private Map<String, CompletionMeta> resultDbMap;

    @Override
    public void registerExamCompletion(String studentId, CompletionMeta completionMeta) {
        this.resultDbMap.put(studentId, completionMeta);
        System.out.println("Exam Submitted!");
    }
}