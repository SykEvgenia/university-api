package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.group.AddGroupDto;
import com.github.zhenya.university.api.dto.group.PutGroupDto;
import com.github.zhenya.university.api.entity.Group;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class ConvertorGroupEntity {

    public Group convertToGroup(AddGroupDto dto) {
        return Group.builder()
                .number(dto.getNumber())
                .specialtyName(dto.getSpecialtyName())
                .build();
    }

    public Group convertToGroup(PutGroupDto dto) {
        return Group.builder()
                .id(new ObjectId(dto.getId()))
                .number(dto.getNumber())
                .specialtyName(dto.getSpecialtyName())
                .build();
    }
}
