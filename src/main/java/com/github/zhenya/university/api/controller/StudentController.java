package com.github.zhenya.university.api.controller;

import com.github.zhenya.university.api.dto.student.AddStudentDto;
import com.github.zhenya.university.api.dto.student.PutStudentDto;
import com.github.zhenya.university.api.dto.student.StudentDto;
import com.github.zhenya.university.api.servise.StudentServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class StudentController {

    private StudentServiceImpl service;

    @GetMapping("/student")
    public List<StudentDto> getStudents(@RequestParam("surname") @NotNull String surname,
                                        @RequestParam("groupNumber") @Min(1) int groupNumber) {
        return service.getStudents(surname,groupNumber);
    }

    @PostMapping("/student")
    public StudentDto addStudent(@RequestBody @Valid AddStudentDto dto) {
        return service.addStudent(dto);
    }

    @PutMapping("/student")
    public StudentDto putStudent(@RequestBody @Valid PutStudentDto dto) {
        return service.putStudent(dto);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") @NotBlank String id) {
        service.deleteStudent(id);
    }
}
