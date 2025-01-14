package com.java.lld.searchengine;

import com.java.lld.searchengine.entity.Document;
import com.java.lld.searchengine.repo.InvertedMap;
import com.java.lld.searchengine.repo.NonInvertedMap;
import com.java.lld.searchengine.repo.impl.InvertedMapImpl;
import com.java.lld.searchengine.repo.impl.NonInvertedMapImpl;
import com.java.lld.searchengine.service.SearchService;
import com.java.lld.searchengine.service.impl.SearchServiceImpl;

public class Test {

    public static void main(String[] args) {

        Document doc1 = Document.builder().docId("123").content("Hi I am sharad dutta").build();
        Document doc2 = Document.builder().docId("124").content("I work at onecard").build();
        Document doc3 = Document.builder().docId("125").content("I am a barista").build();

        InvertedMap invertedMap = InvertedMapImpl.builder().build();
        invertedMap.addToInvertedMap(doc1);
        invertedMap.addToInvertedMap(doc2);
        invertedMap.addToInvertedMap(doc3);

        NonInvertedMap nonInvertedMap = NonInvertedMapImpl.builder().build();
        nonInvertedMap.addToNonInvertedMap(doc1);
        nonInvertedMap.addToNonInvertedMap(doc2);
        nonInvertedMap.addToNonInvertedMap(doc3);

        SearchService searchService = SearchServiceImpl.builder().invertedMap(invertedMap).nonInvertedMap(nonInvertedMap).build();

        searchService.search("Hi");
        searchService.search("onecard");
        searchService.search("I");

        Document doc4 = Document.builder().docId("126").content("apple-pie is sweet").build();
        invertedMap.addToInvertedMap(doc4);
        nonInvertedMap.addToNonInvertedMap(doc4);

        searchService.search("apple");
    }
}
