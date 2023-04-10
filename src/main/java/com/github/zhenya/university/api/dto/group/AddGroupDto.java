package com.github.zhenya.university.api.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddGroupDto {

    @Min(1)
    @JsonProperty("number")
    private int number;
    @NotBlank
    @JsonProperty("specialtyName")
    private String specialtyName;
}
