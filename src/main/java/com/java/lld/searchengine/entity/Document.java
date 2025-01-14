package com.java.lld.searchengine.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Document {
    private String docId;
    private String content;
}
