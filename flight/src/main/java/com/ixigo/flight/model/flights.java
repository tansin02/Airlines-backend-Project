package com.ixigo.flight.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysema.query.annotations.QueryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@QueryEntity
@Document
public class flights{
    @Id
    private ObjectId id;
    @Indexed
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arr;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dep;
    private String origin;
    private String destination;
    private double fare;
    private airplanes airplane;// add airplane id from airplanes
}
