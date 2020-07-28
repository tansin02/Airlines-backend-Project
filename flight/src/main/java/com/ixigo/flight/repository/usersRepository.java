package com.ixigo.flight.repository;

import com.ixigo.flight.model.users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends MongoRepository<users, ObjectId> {
}
