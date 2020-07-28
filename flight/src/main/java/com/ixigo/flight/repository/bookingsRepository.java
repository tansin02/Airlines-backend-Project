package com.ixigo.flight.repository;

import com.ixigo.flight.model.bookings;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookingsRepository extends MongoRepository<bookings, ObjectId>{
    @Query("{'user.id':?0}")
    List<bookings> findbookingsByuser_id(ObjectId id);
//    , QuerydslPredicateExecutor<bookings>
}
