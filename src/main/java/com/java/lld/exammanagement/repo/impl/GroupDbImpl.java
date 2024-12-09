package com.java.lld.exammanagement.repo.impl;

import com.java.lld.exammanagement.entity.Group;
import com.java.lld.exammanagement.entity.Student;
import com.java.lld.exammanagement.repo.GroupDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class GroupDbImpl implements GroupDb {

    private Map<String, List<String>> groupDbMap;

    @Override
    public void createGroup(Group group) {

        String id = group.getGroupId();
        List<String> students = group.getStudents();

        this.groupDbMap.put(id, students);
    }
}
