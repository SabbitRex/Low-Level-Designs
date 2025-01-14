package com.java.lld.searchengine.service;

import com.java.lld.searchengine.entity.Document;

import javax.print.Doc;
import java.util.List;

public interface SearchService {

    List<Document> search(String keyword);
    void delete(Document document);
}
