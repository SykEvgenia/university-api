package com.github.zhenya.university.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "group")
public class Group {
    @Id
    private ObjectId id;
    @Field("number")
    private int number;
    @Field("specialtyName")
    private String specialtyName;
}
