package com.ixigo.flight.repository;

import com.ixigo.flight.model.airplanes;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface airplanesRepository extends MongoRepository<airplanes, ObjectId> {
    @Query("{ 'company' : ?0 }")
    List<airplanes> findairplanesBycompany(String company);
//    ,QuerydslPredicateExecutor<airplanes>
}
