package com.java.lld.exammanagement.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CompletionMeta {

    private String examId;
    private String completionMetaId;
    private String startDateTime;
    private String endDateTime;
    private String duration;
    private boolean submit;
    private Double score;
}
