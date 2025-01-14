package com.java.lld.searchengine.repo;

import com.java.lld.searchengine.entity.Document;

import java.util.List;

public interface InvertedMap {

    void addToInvertedMap(Document document);
    void removeFromInvertedMap(List<String> strings, Document document);
    List<Document> search(String token);
}
