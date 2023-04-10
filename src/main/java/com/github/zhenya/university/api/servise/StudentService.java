package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.student.AddStudentDto;
import com.github.zhenya.university.api.dto.student.PutStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(AddStudentDto dto);
    List<StudentDto> getStudents(String surname, int groupNumber);
    StudentDto putStudent(PutStudentDto dto);
    void deleteStudent(String id);
}
