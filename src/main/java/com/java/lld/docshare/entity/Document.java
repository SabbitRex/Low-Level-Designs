package com.java.lld.docshare.entity;

import com.java.lld.docshare.enums.PermissionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class Document {

    private String docId;
    private String docSummary;
    private User docOwner;
    private boolean isPrivate = false;
    Map<PermissionType, List<String>> permissionMap;
}
