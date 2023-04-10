package com.github.zhenya.university.api.repository;

import com.github.zhenya.university.api.entity.Group;
import com.github.zhenya.university.api.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {

    List<Student> findAllBySurnameAndGroup(String surname, Group group);

    void deleteAllByGroupId(ObjectId id);
}
