package com.ixigo.flight.repository;

import com.ixigo.flight.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {

}
