package com.ixigo.flight.resource;

import com.ixigo.flight.model.Book;
import com.ixigo.flight.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository repo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repo.save(book);
        return "Added book with id"+book.getId();
    }

    @GetMapping("findAllBooks")
    public List<Book> getBooks(){
        return repo.findAll();
    }

    @GetMapping("/findBookbyid/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repo.findById(id);
    }

    @DeleteMapping("/deleteBookbyID/{id}")
    public String deleteBook(@PathVariable int id){
        repo.deleteById(id);
        return "Book deleted with id:"+id;
    }
}
