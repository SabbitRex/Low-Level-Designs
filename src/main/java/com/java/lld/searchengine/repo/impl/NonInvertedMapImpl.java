package com.java.lld.searchengine.repo.impl;

import com.java.lld.searchengine.entity.Document;
import com.java.lld.searchengine.repo.NonInvertedMap;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Builder
@Getter
@Setter
public class NonInvertedMapImpl implements NonInvertedMap {

    private final Map<Document, List<String>> nonInvertedDb = new HashMap<>();

    @Override
    public void addToNonInvertedMap(Document document) {

        String[] tokens = document.getContent().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        this.nonInvertedDb.put(document, list);
    }

    @Override
    public List<String> deleteFromNonInvertedMap(Document document) {
        List<String> strings = this.nonInvertedDb.get(document);
        this.nonInvertedDb.remove(document);
        return strings;
    }
}
