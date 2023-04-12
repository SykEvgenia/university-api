package com.github.zhenya.university.api.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "group")
public class Group {
    @Id
    private ObjectId id;
    @Field("number")
    @Indexed(unique = true)
    private int number;
    @Field("specialtyName")
    private String specialtyName;
}
