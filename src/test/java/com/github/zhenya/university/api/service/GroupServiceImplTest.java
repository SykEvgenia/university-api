package com.github.zhenya.university.api.service;

import com.github.zhenya.university.api.dto.group.CrudGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.GroupServiceImpl;
import com.github.zhenya.university.api.servise.convertor.GroupDtoConvertor;
import com.github.zhenya.university.api.servise.convertor.GroupEntityConvertor;
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
    private GroupEntityConvertor groupEntityConvertor;
    @Mock
    private GroupDtoConvertor groupDtoConvertor;

    @InjectMocks
    private GroupServiceImpl service;

    private final GroupDto groupDto = new GroupDto();
    private final Group group = new Group();
    private final CrudGroupDto crudGroupDto = new CrudGroupDto();

    @Test
    public void addGroup() {
        when(groupEntityConvertor.convertToGroup(any())).thenReturn(group);
        when(repository.save(any())).thenReturn(group);
        when(groupDtoConvertor.convertToGroupDto(any())).thenReturn(groupDto);

        GroupDto dto = service.addGroup(crudGroupDto);

        assertNotNull(dto);
        verify(groupEntityConvertor).convertToGroup(any());
        verify(repository).save(notNull());
        verify(groupDtoConvertor).convertToGroupDto(any());
    }

    @Test
    public void putGroup() {
        when(groupEntityConvertor.convertToGroup(any(), any())).thenReturn(group);
        when(repository.save(any())).thenReturn(group);
        when(groupDtoConvertor.convertToGroupDto(any())).thenReturn(groupDto);

        GroupDto dto = service.putGroup("6431a3775f131e00aa69014f", crudGroupDto);

        assertNotNull(dto);
        verify(groupEntityConvertor).convertToGroup(any(), any());
        verify(repository).save(notNull());
        verify(groupDtoConvertor).convertToGroupDto(any());
    }

    @Test
    public void getGroups() {
        when(repository.findAll()).thenReturn(List.of(group));
        when(groupDtoConvertor.convertToGroupsDto(anyList())).thenReturn(List.of(groupDto));

        List<GroupDto> groups = service.getGroups();

        assertNotNull(groups);
        verify(repository).findAll();
        verify(groupDtoConvertor).convertToGroupsDto(anyList());
    }

    @Test
    public void deleteGroup() {
        service.deleteGroup("6431a3775f131e00aa69014f");

        verify(studentRepository).deleteAllByGroupId(new ObjectId("6431a3775f131e00aa69014f"));
        verify(repository).deleteById(new ObjectId("6431a3775f131e00aa69014f"));
    }
}
