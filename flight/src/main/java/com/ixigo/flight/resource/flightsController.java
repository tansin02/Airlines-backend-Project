package com.ixigo.flight.resource;

import com.ixigo.flight.model.airplanes;
import com.ixigo.flight.model.flights;
import com.ixigo.flight.repository.flightsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class flightsController {

    @Autowired
    private flightsRepository repo;

    @PostMapping("/addflights")
    public String saveFlights(@RequestBody flights flight){
        repo.save(flight);
        return "Added flight details with id"+flight.getId();
    }

    @GetMapping("/findAllFlights")
    public List<flights> findAllFlights(){ return repo.findAll();}

    @GetMapping("/findFlightByID/{id}")
    public Optional<flights> findFlightByID(@PathVariable ObjectId id){
        return repo.findById(id);
    }

    @GetMapping("/findFlightBy/{origin}/{destination}/{enddate}/{startdate}")
    public List<flights> findflightsBy(@PathVariable String origin, String destination, LocalDateTime enddate, LocalDateTime startdate){
        return repo.findflightsByoriginAndDestinationAndDepIsBetween(origin,destination,enddate,startdate);
    }

    @DeleteMapping("/deleteFlightByID/{id}")
    public String deleteFlight(@PathVariable ObjectId id){
        repo.deleteById(id);
        return "Flight deleted with id:"+id;
    }

}
