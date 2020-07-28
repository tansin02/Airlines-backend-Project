package com.ixigo.flight.resource;

import com.ixigo.flight.model.airplanes;
import com.ixigo.flight.repository.airplanesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class airplanesController {

    @Autowired
    private airplanesRepository repo;

    @PostMapping("/addPlanes")
    public String saveAirplanes(@RequestBody airplanes ap){
        if(ap.getNoOfSeats()<=ap.getCountOfSeats())
        {
            return "Plane is Full";
        }
        repo.save(ap);
        return "Added plane with id"+ap.getId();
    }

    @GetMapping("/findAllPlanes")
    public List<airplanes> findAllPlanes(){ return repo.findAll();}

    @GetMapping("/findPlaneByID/{id}")
    public Optional<airplanes> findPlaneByID(@PathVariable ObjectId id){
        return repo.findById(id);
    }

    @GetMapping("/findPlaneByCompany/{company}")
    public List<airplanes> findPlaneByCompany(@PathVariable String company){
        return repo.findairplanesBycompany(company);
    }

    @DeleteMapping("/deletePlanebyID/{id}")
    public String deletePlane(@PathVariable ObjectId id){
        repo.deleteById(id);
        return "Airplane deleted with id:"+id;
    }
}
