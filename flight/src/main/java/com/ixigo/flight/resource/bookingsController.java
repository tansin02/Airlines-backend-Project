package com.ixigo.flight.resource;

import com.ixigo.flight.model.airplanes;
import com.ixigo.flight.model.bookings;
import com.ixigo.flight.model.users;
import com.ixigo.flight.repository.airplanesRepository;
import com.ixigo.flight.repository.bookingsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bookingsController {

    @Autowired
    private bookingsRepository repo;

    @Autowired
    private airplanesRepository airplanesrepo;

    @PostMapping("/addBookings")
    public String addBookings(@RequestBody bookings booking){
        repo.save(booking);
        airplanes ap=booking.getFlight().getAirplane();
        int temp=ap.getCountOfSeats();
        ap.setCountOfSeats(temp+1);
        airplanesrepo.save(ap);
        return "Booking has been added with id"+booking.getId();
    }

    @GetMapping("/findAllBookings")
    public List<bookings> findAllBookings(){ return repo.findAll();}

    @GetMapping("/findBookingByID/{id}")
    public Optional<bookings> findBookingByID(@PathVariable ObjectId id){
        return repo.findById(id);
    }

    @GetMapping("/findAllBookingsByUserID/{id}")
    public List<bookings> findAllBookingsByUserID(@PathVariable ObjectId id){
        return repo.findbookingsByuser_id(id);
    }

    @DeleteMapping("/deleteBookingbyID/{id}")
    public String deleteBookingbyID(@PathVariable ObjectId id){
        repo.deleteById(id);
        return "Booking deleted with id:"+id;
    }
}
