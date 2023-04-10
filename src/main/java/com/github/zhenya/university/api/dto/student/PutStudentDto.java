package com.github.zhenya.university.api.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PutStudentDto {

    @NotBlank
    @JsonProperty("id")
    private String id;
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("surname")
    private String surname;
    @NotBlank
    @JsonProperty("patronymic")
    private String patronymic;
    @NotNull
    @JsonProperty("birthDate")
    private LocalDate birthDate;
    @NotBlank
    @JsonProperty("groupId")
    private String groupId;
}
