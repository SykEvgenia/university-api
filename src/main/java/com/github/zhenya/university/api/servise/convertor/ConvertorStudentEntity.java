package com.github.zhenya.university.api.servise.convertor;

import com.github.zhenya.university.api.dto.student.AddStudentDto;
import com.github.zhenya.university.api.dto.student.PutStudentDto;
import com.github.zhenya.university.api.entity.Student;
import com.github.zhenya.university.api.repository.GroupRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConvertorStudentEntity {

    private GroupRepository groupRepository;

    public Student convertToStudent(AddStudentDto dto) {
        return Student.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .birthDate(dto.getBirthDate())
                .group(groupRepository.findById(new ObjectId(dto.getGroupId()))
                        .orElseThrow(() -> new ValidationException("Такої групи не знайдено")))
                .build();
    }

    public Student convertToStudent(PutStudentDto dto){
        return Student.builder()
                .id(new ObjectId(dto.getId()))
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .birthDate(dto.getBirthDate())
                .group(groupRepository.findById(new ObjectId(dto.getGroupId()))
                        .orElseThrow(() -> new ValidationException("Такої групи не знайдено")))
                .build();
    }
}
