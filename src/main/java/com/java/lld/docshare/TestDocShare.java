package com.java.lld.docshare;

import com.java.lld.docshare.entity.Document;
import com.java.lld.docshare.entity.User;
import com.java.lld.docshare.enums.ActionType;
import com.java.lld.docshare.enums.PermissionType;
import com.java.lld.docshare.repo.DocDb;
import com.java.lld.docshare.repo.UserDb;
import com.java.lld.docshare.repo.impl.DocDbImpl;
import com.java.lld.docshare.repo.impl.UserDbImpl;
import com.java.lld.docshare.service.DocManagementService;
import com.java.lld.docshare.service.UserManagementService;
import com.java.lld.docshare.service.impl.DocManagementServiceImpl;
import com.java.lld.docshare.service.impl.UserManagementServiceImpl;

import java.util.HashMap;

public class TestDocShare {

    /*
    1. All documents are private when created. - Done
    2. Owners of documents can {grant} {read OR edit} access to other users - Done
    3. Only the owner can delete a document - Done
    4. Username will be just a string. - Done
    5. Every action like create/read/edit/delete must be made on behalf of a user - Done
    */
    public static void main(String[] args) {

        UserDb userDb = UserDbImpl.builder().build();
        UserManagementService userClient = UserManagementServiceImpl.builder().userDb(userDb).build();

        DocDb docDb = DocDbImpl.builder().build();
        DocManagementService docClient = DocManagementServiceImpl.builder().docDb(docDb).build();

        User u1 = userClient.createUser(User.builder().userName("Sharad").build());
        User u2 = userClient.createUser(User.builder().userName("Anurag").build());

        Document d1u1 = docClient.createDoc(Document.builder().permissionMap(new HashMap<>()).docId("1234").docSummary("I am a doc1 made by Sharad.").docOwner(u1).isPrivate(true).build());
        Document d1u2 = docClient.createDoc(Document.builder().permissionMap(new HashMap<>()).docId("4321").docSummary("I am a doc1 made by Anurag.").docOwner(u2).isPrivate(true).build());
        Document d2u2 = docClient.createDoc(Document.builder().permissionMap(new HashMap<>()).docId("4320").docSummary("I am a doc2 made by Anurag.").docOwner(u2).isPrivate(true).build());

        docClient.deleteDoc("1234", "Anurag");
//        docClient.deleteDoc("1234", "Sharad");

        System.out.println(docClient.readDoc("1234", "Sharad"));
        System.out.println(docClient.readDoc("1234", "Anurag"));

        docClient.modifyDocPermission("1234", "Sharad", "Anurag", PermissionType.READ, ActionType.ADD);
        System.out.println(docClient.readDoc("1234", "Anurag"));

        docClient.modifyDocPermission("1234", "Sharad", "Anurag", PermissionType.READ, ActionType.REMOVE);
        System.out.println(docClient.readDoc("1234", "Anurag"));

    }
}
