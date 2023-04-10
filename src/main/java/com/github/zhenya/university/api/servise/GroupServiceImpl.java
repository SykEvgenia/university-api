package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.group.AddGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.dto.group.PutGroupDto;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.convertor.ConvertorGroupDto;
import com.github.zhenya.university.api.servise.convertor.ConvertorGroupEntity;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;
    private ConvertorGroupEntity convertorGroupEntity;
    private ConvertorGroupDto convertorGroupDto;

    @Override
    public GroupDto addGroup(AddGroupDto dto) {
        return convertorGroupDto.convertToGroupDto(groupRepository.save(convertorGroupEntity.convertToGroup(dto)));
    }

    @Override
    public GroupDto putGroup(PutGroupDto dto) {
        return convertorGroupDto.convertToGroupDto(groupRepository.save(convertorGroupEntity.convertToGroup(dto)));
    }

    @Override
    public List<GroupDto> getGroups() {
        return convertorGroupDto.convertToGroupsDto(groupRepository.findAll());
    }


    @Override
    public void deleteGroup(String id) {
        studentRepository.deleteAllByGroupId(new ObjectId(id));
        groupRepository.deleteById(new ObjectId(id));
    }
}
