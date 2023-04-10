package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.entity.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertorGroupDto {

    public GroupDto convertToGroupDto(Group group) {
        return GroupDto.builder()
                .id(group.getId().toString())
                .number(group.getNumber())
                .specialtyName(group.getSpecialtyName())
                .build();
    }

    public List<GroupDto> convertToGroupsDto(List<Group> groups) {
        return groups.stream()
                .map(this::convertToGroupDto)
                .toList();
    }
}
