package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConvertorStudentDto {

    public StudentDto convertToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId().toString())
                .name(student.getName())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .birthDate(student.getBirthDate())
                .build();
    }
}
