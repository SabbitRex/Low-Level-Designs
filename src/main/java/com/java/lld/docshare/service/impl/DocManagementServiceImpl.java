package com.java.lld.docshare.service.impl;

import com.java.lld.docshare.entity.Document;
import com.java.lld.docshare.enums.ActionType;
import com.java.lld.docshare.enums.PermissionType;
import com.java.lld.docshare.repo.DocDb;
import com.java.lld.docshare.service.DocManagementService;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class DocManagementServiceImpl implements DocManagementService {

    private final DocDb docDb;

    @Override
    public Document createDoc(Document document) {
        return this.docDb.createDoc(document);
    }

    @Override
    public void deleteDoc(String docId, String userName) {
        this.docDb.deleteDoc(docId, userName);
    }

    @Override
    public void modifyDocPermission(String docId, String ownerUserName, String userName, PermissionType permissionType, ActionType actionType) {

        Document document = this.docDb.getDoc(docId);

        if (document != null) {

            if (document.getDocOwner().getUserName().equalsIgnoreCase(ownerUserName)) {

                List<String> users = document.getPermissionMap().get(permissionType);

                if (users == null) {
                    users = new ArrayList<String>();
                }

                if (actionType.name().equalsIgnoreCase("add")) {
                    users.add(userName);

                } else if (actionType.name().equalsIgnoreCase("remove")) {
                    users.remove(userName);
                }

                document.getPermissionMap().put(permissionType, users);
                this.docDb.updateDoc(document);

            } else {

                System.out.println("Only owner can modify permission!");
            }

        } else {
            System.out.println("Document does not exist");
        }
    }

    @Override
    public String readDoc(String docId, String userName) {

        Document document = this.docDb.getDoc(docId);

        if (document.getPermissionMap() != null) {

            if (userName.equalsIgnoreCase(document.getDocOwner().getUserName()) || document.getPermissionMap().get(PermissionType.READ) != null && document.getPermissionMap().get(PermissionType.READ).contains(userName)) {

                return document.getDocSummary();
            }

        }

        return "No read permission for user.";
    }
}