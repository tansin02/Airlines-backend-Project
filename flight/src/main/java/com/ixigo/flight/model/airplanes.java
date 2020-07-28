package com.ixigo.flight.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "airplanes")
public class airplanes {

    @Id
    private ObjectId id;
    @Indexed
    private String company;
    private String typeOfPlane;
    private int noOfSeats;
    private int countOfSeats=0;
}
