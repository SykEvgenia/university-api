package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.student.CrudStudentDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class StudentEntityConvertor {

    public Student convertToStudent(CrudStudentDto dto, Group group) {
        return Student.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .birthDate(dto.getBirthDate())
                .group(group)
                .build();
    }

    public Student convertToStudent(String id, CrudStudentDto dto, Group group) {
        return Student.builder()
                .id(new ObjectId(id))
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .birthDate(dto.getBirthDate())
                .group(group)
                .build();
    }
}
