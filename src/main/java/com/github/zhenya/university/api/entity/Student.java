package com.github.zhenya.university.api.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
@CompoundIndexes({
        @CompoundIndex(unique = true, name = "student", def = "{'name' : 1, 'surname': 1, 'patronymic': 1, 'birthDate': 1}")
})
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
