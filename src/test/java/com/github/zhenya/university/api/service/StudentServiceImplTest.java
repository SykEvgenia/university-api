package com.github.zhenya.university.api.service;

import com.github.zhenya.university.api.dto.student.CrudStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.entity.Student;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.StudentServiceImpl;
import com.github.zhenya.university.api.servise.convertor.StudentDtoConvertor;
import com.github.zhenya.university.api.servise.convertor.StudentEntityConvertor;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentEntityConvertor studentEntityConvertor;
    @Mock
    private StudentDtoConvertor studentDtoConvertor;

    @InjectMocks
    private StudentServiceImpl service;

    private final Student student = new Student();
    private final CrudStudentDto crudStudentDto =  getCrudStudentDto();
    private final StudentDto studentDto = new StudentDto();
    private final Group group = new Group();

    @Test
    public void addStudent() {
        when(studentEntityConvertor.convertToStudent(any(), any())).thenReturn(student);
        when(groupRepository.findById(any())).thenReturn(Optional.of(group));
        when(studentRepository.save(any())).thenReturn(student);
        when(studentDtoConvertor.convertToStudentDto(any())).thenReturn(studentDto);

        StudentDto dto = service.addStudent(crudStudentDto);

        assertNotNull(dto);
        verify(studentEntityConvertor).convertToStudent(any(), any());
        verify(groupRepository).findById(any());
        verify(studentDtoConvertor).convertToStudentDto(any());
    }

    @Test
    public void getStudents() {
        when(studentDtoConvertor.convertToStudentDto(any())).thenReturn(studentDto);
        when(studentRepository.findAllBySurnameAndGroup(any(), any())).thenReturn(List.of(student));
        when(groupRepository.findByNumber(154)).thenReturn(Optional.of(group));

        List<StudentDto> studentsDto = service.getStudents("Петрук", 154);

        assertNotNull(studentsDto);
        verify(groupRepository).findByNumber(154);
        verify(studentRepository).findAllBySurnameAndGroup("Петрук", group);
        verify(studentDtoConvertor).convertToStudentDto(any());
    }

    @Test
    public void putStudent() {
        when(studentEntityConvertor.convertToStudent(any(), any(), any())).thenReturn(student);
        when(groupRepository.findById(any())).thenReturn(Optional.of(group));
        when(studentRepository.save(any())).thenReturn(student);
        when(studentDtoConvertor.convertToStudentDto(any())).thenReturn(studentDto);

        StudentDto dto = service.putStudent("64355b9588ff384db4c0c0f0", crudStudentDto);

        assertNotNull(dto);
        verify(studentEntityConvertor).convertToStudent(any(), any(), any());
        verify(groupRepository).findById(any());
        verify(studentRepository).save(any());
        verify(studentDtoConvertor).convertToStudentDto(any());
    }

    @Test
    public void deleteStudent() {
        service.deleteStudent("64355b9588ff384db4c0c0f0");

        verify(studentRepository).deleteById(new ObjectId("64355b9588ff384db4c0c0f0"));
    }

    private CrudStudentDto getCrudStudentDto() {
        return CrudStudentDto.builder()
                .groupId("643595897356834ddfb25daf")
                .build();
    }
}