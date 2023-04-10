package com.github.zhenya.university.api.servise;

import com.github.zhenya.university.api.dto.student.AddStudentDto;
import com.github.zhenya.university.api.dto.student.PutStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.entity.Student;
import com.github.zhenya.university.api.repository.GroupRepository;
import com.github.zhenya.university.api.repository.StudentRepository;
import com.github.zhenya.university.api.servise.convertor.ConvertorStudentDto;
import com.github.zhenya.university.api.servise.convertor.ConvertorStudentEntity;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private ConvertorStudentEntity convertorStudentEntity;
    private ConvertorStudentDto convertorStudentDto;

    @Override
    public StudentDto addStudent(AddStudentDto dto) {
        return convertorStudentDto.convertToStudentDto(studentRepository
                .save(convertorStudentEntity.convertToStudent(dto)));
    }

    @Override
    public List<StudentDto> getStudents(String surname, int groupNumber) {
        return searchStudent(surname, groupNumber).stream()
                .map(student -> convertorStudentDto.convertToStudentDto(student))
                .toList();
    }

    @Override
    public StudentDto putStudent(PutStudentDto dto) {
        return convertorStudentDto.convertToStudentDto(studentRepository
                .save(convertorStudentEntity.convertToStudent(dto)));
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(new ObjectId(id));
    }

    private List<Student> searchStudent(String surname, int groupNumber) {
        return studentRepository.findAllBySurnameAndGroup(surname, groupRepository.findByNumber(groupNumber));
    }
}
