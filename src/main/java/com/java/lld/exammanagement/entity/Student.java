package com.java.lld.exammanagement.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
}
