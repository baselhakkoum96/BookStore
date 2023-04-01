package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@RestController
public class RESTController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/books/{id}")
	@ResponseBody
	public Book getBookById(@PathVariable Long id) {
		Optional<Book> optionalBook = repository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	@GetMapping("/books/search/findByTitle")
	@ResponseBody
	public List<Book> getBooksByTitle(@RequestParam("title") String title) {
	    return repository.findByTitle(title);
	}
   @DeleteMapping("/books/{id}/delete")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
