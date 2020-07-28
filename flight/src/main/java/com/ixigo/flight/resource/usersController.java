package com.ixigo.flight.resource;

import com.ixigo.flight.model.airplanes;
import com.ixigo.flight.model.users;
import com.ixigo.flight.repository.usersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class usersController {

    @Autowired
    private usersRepository repo;

    @PostMapping("/addUsers")
    public String saveUser(@RequestBody users user){
        repo.save(user);
        return "Added plane with id"+user.getId();
    }

    @GetMapping("/findAllUsers")
    public List<users> findAllUsers(){ return repo.findAll();}

    @GetMapping("/findUserByID/{id}")
    public Optional<users> findUserByID(@PathVariable ObjectId id){
        return repo.findById(id);
    }

    @DeleteMapping("/deleteUserByID/{id}")
    public String deleteUserbyID(@PathVariable ObjectId id){
        repo.deleteById(id);
        return "User deleted with id:"+id;
    }
}
