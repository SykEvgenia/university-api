package com.github.zhenya.university.api.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("number")
    private int number;
    @JsonProperty("specialtyName")
    private String specialtyName;
}
