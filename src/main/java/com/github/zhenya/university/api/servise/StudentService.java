package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.student.CrudStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(CrudStudentDto dto);

    List<StudentDto> getStudents(String surname, int groupNumber);

    StudentDto putStudent(String id, CrudStudentDto dto);

    void deleteStudent(String id);
}
