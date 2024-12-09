package com.java.lld.exammanagement.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Schedule {

    private String startDateTime;
    private String endDateTime;
    private String timezone;
}
