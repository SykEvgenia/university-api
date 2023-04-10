package com.github.zhenya.university.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private ObjectId id;
    @Field("name")
    private String name;
    @Field("surname")
    private String surname;
    @Field("patronymic")
    private String patronymic;
    @Field("birthDate")
    private LocalDate birthDate;
    @DBRef
    @Field("group")
    private Group group;
}
