package com.java.lld.searchengine.service.impl;

import com.java.lld.searchengine.entity.Document;
import com.java.lld.searchengine.repo.InvertedMap;
import com.java.lld.searchengine.repo.NonInvertedMap;
import com.java.lld.searchengine.service.SearchService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;
import java.util.List;

@Builder
@Getter
@Setter
public class SearchServiceImpl implements SearchService {

    private final InvertedMap invertedMap;
    private final NonInvertedMap nonInvertedMap;

    @Override
    public List<Document> search(String keyword) {
        List<Document> documents =  this.invertedMap.search(keyword);

        for (Document document : documents) {
            System.out.printf("Doc ID : %s%n", document.getDocId());
        }

        return documents;
    }

    @Override
    public void delete(Document document) {
        List<String> strings = this.nonInvertedMap.deleteFromNonInvertedMap(document);
        this.invertedMap.removeFromInvertedMap(strings, document);
    }
}
