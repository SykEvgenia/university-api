package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.group.CrudGroupDto;
import com.github.zhenya.university.api.entity.Group;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityConvertor {

    public Group convertToGroup(CrudGroupDto dto) {
        return Group.builder()
                .number(dto.getNumber())
                .specialtyName(dto.getSpecialtyName())
                .build();
    }

    public Group convertToGroup(String id, CrudGroupDto dto) {
        return Group.builder()
                .id(new ObjectId(id))
                .number(dto.getNumber())
                .specialtyName(dto.getSpecialtyName())
                .build();
    }
}
