package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.group.CrudGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.convertor.GroupDtoConvertor;
import com.github.zhenya.university.api.servise.convertor.GroupEntityConvertor;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;
    private GroupEntityConvertor groupEntityConvertor;
    private GroupDtoConvertor groupDtoConvertor;

    @Override
    public GroupDto addGroup(CrudGroupDto dto) {
        return groupDtoConvertor.convertToGroupDto(groupRepository.save(groupEntityConvertor.convertToGroup(dto)));
    }

    @Override
    public GroupDto putGroup(String id, CrudGroupDto dto) {
        return groupDtoConvertor.convertToGroupDto(groupRepository.save(groupEntityConvertor.convertToGroup(id, dto)));
    }

    @Override
    public List<GroupDto> getGroups() {
        return groupDtoConvertor.convertToGroupsDto(groupRepository.findAll());
    }


    @Override
    public void deleteGroup(String id) {
        studentRepository.deleteAllByGroupId(new ObjectId(id));
        groupRepository.deleteById(new ObjectId(id));
    }
}
