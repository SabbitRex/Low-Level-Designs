package com.java.lld.docshare.service;

import com.java.lld.docshare.entity.Document;
import com.java.lld.docshare.enums.ActionType;
import com.java.lld.docshare.enums.PermissionType;

public interface DocManagementService {

    Document createDoc(Document document);
    void deleteDoc(String docId, String userName);
    void modifyDocPermission(String docId, String ownerUserName, String userName, PermissionType permissionType, ActionType actionType);
    String readDoc(String docId, String userName);
}
