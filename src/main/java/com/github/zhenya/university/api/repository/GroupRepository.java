package com.github.zhenya.university.api.repository;

import com.github.zhenya.university.api.entity.Group;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {
    Group findByNumber(int number);
}
