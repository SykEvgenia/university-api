package com.github.zhenya.university.api.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GroupDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("number")
    private int number;
    @JsonProperty("specialtyName")
    private String specialtyName;
}
