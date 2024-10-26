package com.java.lld.docshare.repo;

import com.java.lld.docshare.entity.Document;

public interface DocDb {
    Document createDoc(Document document);
    void deleteDoc(String docId, String userName);
    Document getDoc(String docId);
    void updateDoc(Document document);
}
