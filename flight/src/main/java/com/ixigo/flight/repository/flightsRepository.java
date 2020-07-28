package com.ixigo.flight.repository;

import com.ixigo.flight.model.flights;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface flightsRepository extends MongoRepository<flights, ObjectId>{
    @Query("{'origin':?0,'destination':?1,'dep': : {$lt : ?2, $gt : ?3}}")
    List<flights> findflightsByoriginAndDestinationAndDepIsBetween(String origin,String destination, LocalDateTime enddate,LocalDateTime startdate);
//    , QuerydslPredicateExecutor<flights>
}
