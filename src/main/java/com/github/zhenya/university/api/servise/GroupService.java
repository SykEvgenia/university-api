package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.group.CrudGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;

import java.util.List;

public interface GroupService {

    GroupDto addGroup(CrudGroupDto dto);
    GroupDto putGroup(String id, CrudGroupDto dto);
    List<GroupDto> getGroups();
    void deleteGroup(String id);
}
