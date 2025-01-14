package com.java.lld.searchengine.repo;

import com.java.lld.searchengine.entity.Document;

import java.util.List;

public interface NonInvertedMap {

    void addToNonInvertedMap(Document document);
    List<String> deleteFromNonInvertedMap(Document document);
}
