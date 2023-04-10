package com.github.zhenya.university.api.service;

import com.github.zhenya.university.api.dto.student.AddStudentDto;
import com.github.zhenya.university.api.dto.student.PutStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.entity.Student;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.StudentServiceImpl;
import com.github.zhenya.university.api.servise.convertor.ConvertorStudentDto;
import com.github.zhenya.university.api.servise.convertor.ConvertorStudentEntity;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

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
    private ConvertorStudentEntity convertorStudentEntity;
    @Mock
    private ConvertorStudentDto convertorStudentDto;

    @InjectMocks
    private StudentServiceImpl service;

    private final Student student = getStudent();
    private final AddStudentDto addStudentDto = getAddStudentDto();
    private final StudentDto studentDto = getStudentDto();
    private final Group group = getGroup();
    private final PutStudentDto putStudentDto = getPutStudentDto();

    @Test
    public void addStudent() {
        when(convertorStudentEntity.convertToStudent(any(AddStudentDto.class))).thenReturn(student);
        when(studentRepository.save(any())).thenReturn(student);
        when(convertorStudentDto.convertToStudentDto(any())).thenReturn(studentDto);

        StudentDto dto = service.addStudent(addStudentDto);

        assertNotNull(dto);
        verify(convertorStudentEntity).convertToStudent(any(AddStudentDto.class));
        verify(studentRepository).save(any());
        verify(convertorStudentDto).convertToStudentDto(any());
    }

    @Test
    public void getStudents() {
        when(convertorStudentDto.convertToStudentDto(any())).thenReturn(studentDto);
        when(groupRepository.findByNumber(154)).thenReturn(group);
        when(studentRepository.findAllBySurnameAndGroup(any(), any())).thenReturn(List.of(student));

        List<StudentDto> studentsDto = service.getStudents("Петрук", 154);

        assertNotNull(studentsDto);
        verify(groupRepository).findByNumber(154);
        verify(studentRepository).findAllBySurnameAndGroup("Петрук", group);
        verify(convertorStudentDto).convertToStudentDto(any());
    }

    @Test
    public void putStudent() {
        when(convertorStudentEntity.convertToStudent(any(PutStudentDto.class))).thenReturn(student);
        when(studentRepository.save(any())).thenReturn(student);
        when(convertorStudentDto.convertToStudentDto(any())).thenReturn(studentDto);

        StudentDto dto = service.putStudent(putStudentDto);

        assertNotNull(dto);
        verify(convertorStudentEntity).convertToStudent(any(PutStudentDto.class));
        verify(studentRepository).save(any());
        verify(convertorStudentDto).convertToStudentDto(any());
    }

    @Test
    public void deleteStudent(){
        service.deleteStudent("6432bedeede50d7249a487ae");

        verify(studentRepository).deleteById(new ObjectId("6432bedeede50d7249a487ae"));
    }

    private PutStudentDto getPutStudentDto() {
        return PutStudentDto.builder()
                .id("6432bedeede50d7249a487ae")
                .groupId("6432bd64ede50d7249a487ad")
                .name("Михайло")
                .patronymic("Панасович")
                .surname("Петрук")
                .birthDate(LocalDate.ofEpochDay(2003 - 3 - 3))
                .build();
    }

    private StudentDto getStudentDto() {
        return StudentDto.builder()
                .id("6432bedeede50d7249a487ae")
                .name("Михайло")
                .patronymic("Панасович")
                .surname("Петрук")
                .birthDate(LocalDate.ofEpochDay(2003 - 3 - 3))
                .build();
    }

    private Student getStudent() {
        return Student.builder()
                .id(new ObjectId("6432bedeede50d7249a487ae"))
                .group(getGroup())
                .name("Михайло")
                .patronymic("Панасович")
                .surname("Петрук")
                .birthDate(LocalDate.ofEpochDay(2003 - 3 - 3))
                .build();
    }

    private AddStudentDto getAddStudentDto() {
        return AddStudentDto.builder()
                .groupId("6432bd64ede50d7249a487ad")
                .name("Михайло")
                .patronymic("Панасович")
                .surname("Петрук")
                .birthDate(LocalDate.ofEpochDay(2003 - 3 - 3))
                .build();
    }

    private Group getGroup() {
        return Group.builder()
                .id(new ObjectId("6431a3775f131e00aa69014f"))
                .number(154)
                .specialtyName("Економіка")
                .build();
    }
}