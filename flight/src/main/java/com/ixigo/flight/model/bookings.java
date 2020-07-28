package com.ixigo.flight.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysema.query.annotations.QueryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

enum typeofpax{
    adl,
    inf,
    chl
}
@Getter
@Setter
@ToString
//@QueryEntity
@Document
public class bookings {
    @Id
    private ObjectId id;
    //flight id
    private flights flight;
    //userid
    private users user;
    private ArrayList<String> namesOfPassengers;
    private ArrayList<typeofpax> top;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created=LocalDateTime.now();
    private double fare=flight.getFare()*1.5;
    private int count=0;
}
