package com.github.zhenya.university.api.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudGroupDto {

    @Min(1)
    @JsonProperty("number")
    private int number;
    @NotBlank
    @JsonProperty("specialtyName")
    private String specialtyName;
}
