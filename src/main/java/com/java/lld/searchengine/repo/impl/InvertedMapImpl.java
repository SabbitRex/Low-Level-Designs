package com.java.lld.searchengine.repo.impl;

import com.java.lld.searchengine.entity.Document;
import com.java.lld.searchengine.repo.InvertedMap;
import com.java.lld.searchengine.repo.NonInvertedMap;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;
import java.util.*;

@Builder
@Setter
@Getter
public class InvertedMapImpl implements InvertedMap {

    private final Map<String, List<Document>> invertedDb = new HashMap<>();
    private NonInvertedMap nonInvertedMap;

    @Override
    public List<Document> search(String searchTerm) {

        String[] tokens = searchTerm.split(" ");

        List<Document> result = new ArrayList<>();

        for (String token : tokens) {

            if (this.invertedDb.containsKey(token)) {

                List<Document> docs = this.invertedDb.get(token);
                result.addAll(docs);
            }
        }

        return result;
    }

    @Override
    public void addToInvertedMap(Document document) {

        List<String> tokens = this.convertDocToToken(document);

        for (String token : tokens) {
            if (this.invertedDb.containsKey(token)) {

                List<Document> result = this.invertedDb.get(token);
                result.add(document);
                this.invertedDb.put(token, result);
                System.out.println("document added!");
            } else {
                List<Document> documents = new ArrayList<>();
                documents.add(document);
                this.invertedDb.put(token, documents);
            }
        }

    }

    private List<String> convertDocToToken(Document document) {

        String[] tokens = document.getContent().split(" ");
        return new ArrayList<>(Arrays.asList(tokens));
    }

    @Override
    public void removeFromInvertedMap(List<String> strings, Document document) {

        for (String string : strings) {

            if (this.invertedDb.containsKey(string)) {

                List<Document> documents = this.invertedDb.get(string);
                documents.remove(document);
                this.invertedDb.put(string, documents);
            }
        }
    }
}
