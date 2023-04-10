package com.github.zhenya.university.api.service;

import com.github.zhenya.university.api.dto.group.AddGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.dto.group.PutGroupDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.GroupServiceImpl;
import com.github.zhenya.university.api.servise.convertor.ConvertorGroupDto;
import com.github.zhenya.university.api.servise.convertor.ConvertorGroupEntity;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroupServiceImplTest {

    @Mock
    private GroupRepository repository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ConvertorGroupEntity convertorGroupEntity;
    @Mock
    private ConvertorGroupDto convertorGroupDto;

    @InjectMocks
    private GroupServiceImpl service;

    private final GroupDto groupDto = getGroupDto();
    private final Group group = getGroup();
    private final AddGroupDto addGroupDto = getAddGroupDto();
    private final PutGroupDto putGroupDto = getPutGroupDto();

    @Test
    public void addGroup() {
        when(convertorGroupEntity.convertToGroup(any(AddGroupDto.class))).thenReturn(group);
        when(repository.save(any())).thenReturn(group);
        when(convertorGroupDto.convertToGroupDto(any(Group.class))).thenReturn(groupDto);

        GroupDto dto = service.addGroup(addGroupDto);

        assertNotNull(dto);
        verify(convertorGroupEntity).convertToGroup(any(AddGroupDto.class));
        verify(repository).save(notNull());
        verify(convertorGroupDto).convertToGroupDto(any(Group.class));
    }

    @Test
    public void putGroup() {
        when(convertorGroupEntity.convertToGroup(any(PutGroupDto.class))).thenReturn(group);
        when(repository.save(any())).thenReturn(group);
        when(convertorGroupDto.convertToGroupDto(any(Group.class))).thenReturn(groupDto);

        GroupDto dto = service.putGroup(putGroupDto);

        assertNotNull(dto);
        verify(convertorGroupEntity).convertToGroup(any(PutGroupDto.class));
        verify(repository).save(notNull());
        verify(convertorGroupDto).convertToGroupDto(any(Group.class));
    }

    @Test
    public void getGroups() {
        when(repository.findAll()).thenReturn(List.of(group));
        when(convertorGroupDto.convertToGroupsDto(anyList())).thenReturn(List.of(groupDto));

        List<GroupDto> groups = service.getGroups();

        assertNotNull(groups);
        verify(repository).findAll();
        verify(convertorGroupDto).convertToGroupsDto(anyList());
    }

    @Test
    public void deleteGroup() {
        service.deleteGroup("6431a3775f131e00aa69014f");

        verify(studentRepository).deleteAllByGroupId(new ObjectId("6431a3775f131e00aa69014f"));
        verify(repository).deleteById(new ObjectId("6431a3775f131e00aa69014f"));
    }

    private Group getGroup() {
        return Group.builder()
                .id(new ObjectId("6431a3775f131e00aa69014f"))
                .number(154)
                .specialtyName("Економіка")
                .build();
    }

    private GroupDto getGroupDto() {
        return GroupDto.builder()
                .id("6431a3775f131e00aa69014f")
                .number(154)
                .specialtyName("Економіка")
                .build();
    }

    private AddGroupDto getAddGroupDto() {
        return AddGroupDto.builder()
                .number(154)
                .specialtyName("Економіка")
                .build();
    }

    private PutGroupDto getPutGroupDto() {
        return PutGroupDto.builder()
                .id("6431a3775f131e00aa69014f")
                .number(154)
                .specialtyName("Економіка")
                .build();
    }
}
