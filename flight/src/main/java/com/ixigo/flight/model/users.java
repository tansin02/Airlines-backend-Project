package com.ixigo.flight.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class users {
    @Id
    private ObjectId id;
    private String name;
    private String password;
    private int age;
}
