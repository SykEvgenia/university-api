package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.student.CrudStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.convertor.StudentDtoConvertor;
import com.github.zhenya.university.api.servise.convertor.StudentEntityConvertor;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private StudentEntityConvertor studentEntityConvertor;
    private StudentDtoConvertor studentDtoConvertor;

    @Override
    public StudentDto addStudent(CrudStudentDto dto) {
        return studentDtoConvertor.convertToStudentDto(studentRepository
                .save(studentEntityConvertor.convertToStudent(dto, getGroup(dto.getGroupId()))));
    }

    @Override
    public List<StudentDto> getStudents(String surname, int groupNumber) {
        return studentRepository.findAllBySurnameAndGroup(surname, getGroup(groupNumber)).stream()
                .map(student -> studentDtoConvertor.convertToStudentDto(student))
                .toList();
    }

    @Override
    public StudentDto putStudent(String id, CrudStudentDto dto) {
        return studentDtoConvertor.convertToStudentDto(studentRepository
                .save(studentEntityConvertor.convertToStudent(id, dto, getGroup(dto.getGroupId()))));
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(new ObjectId(id));
    }

    private Group getGroup(String id) {
        return groupRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new ValidationException(String.format("Групу з id = [%s] не знайдено", id)));
    }

    private Group getGroup(int groupNumber) {
        return groupRepository.findByNumber(groupNumber)
                .orElseThrow(() -> new ValidationException(String.format("Групу з number = [%s] не знайдено", groupNumber)));
    }
}
