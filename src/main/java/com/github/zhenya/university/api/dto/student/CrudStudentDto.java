package com.github.zhenya.university.api.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudStudentDto {

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
