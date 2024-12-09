package com.java.lld.exammanagement.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class Group {
    private String groupId;
    private List<String> students;
}