package com.java.lld.exammanagement.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Exam {

    private String examId;
    private String examTitle;
    private Schedule schedule;
    private Group group;
}
