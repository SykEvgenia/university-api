package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.group.AddGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.dto.group.PutGroupDto;

import java.util.List;

public interface GroupService {

    GroupDto addGroup(AddGroupDto dto);
    GroupDto putGroup(PutGroupDto dto);
    List<GroupDto> getGroups();
    void deleteGroup(String id);
}
