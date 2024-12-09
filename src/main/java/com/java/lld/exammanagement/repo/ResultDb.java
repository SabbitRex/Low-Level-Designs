package com.java.lld.exammanagement.repo;

import com.java.lld.exammanagement.entity.CompletionMeta;

public interface ResultDb {

    void registerExamCompletion(String studentId, CompletionMeta completionMeta);
}
