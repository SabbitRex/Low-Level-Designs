package com.java.lld.docshare.repo.impl;

import com.java.lld.docshare.entity.Document;
import com.java.lld.docshare.repo.DocDb;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class DocDbImpl implements DocDb {

    private final Map<String, Document> docDbMap = new HashMap<>();

    @Override
    public Document createDoc(Document document) {

        if (!this.docDbMap.containsKey(document.getDocId())) {

            this.docDbMap.put(document.getDocId(), document);
            System.out.println("Doc created.");

        } else {
            System.out.println("DocId already present.");
        }

        return this.docDbMap.get(document.getDocId());
    }

    @Override
    public void deleteDoc(String docId, String userName) {

        if (this.docDbMap.containsKey(docId)) {

            Document document = this.docDbMap.get(docId);

            if (userName.equals(document.getDocOwner().getUserName())) {
                this.docDbMap.remove(docId);
                System.out.println("Doc owner deleted the doc.");

            } else {
                System.out.println("Only doc owner can delete current doc.");
            }
        }
    }

    @Override
    public Document getDoc(String docId) {

        if (this.docDbMap.containsKey(docId)) {
            return this.docDbMap.get(docId);
        }

        return null;
    }

    @Override
    public void updateDoc(Document document) {
        this.docDbMap.put(document.getDocId(), document);
    }
}