package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookStore {

	public static void main(String[] args) {
		SpringApplication.run(BookStore.class, args);
	}

	@Bean
    public CommandLineRunner demo(@Autowired BookRepository repository, @Autowired CategoryRepository categoryRepository, @Autowired UserRepository userrepository) {
        return (args) -> {
        	categoryRepository.save(new Category("Romance"));
        	categoryRepository.save(new Category("Fantasy"));
        	Book b1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123-23", 55, categoryRepository.findByName("Romance"));
        	Book b2 = new Book("Animal Farm", "George Orwell", 1945, "456654-5", 46,categoryRepository.findByName("Fantasy"));
        	repository.save(b1);
        	repository.save(b2);
        	User normaluser= new User("user","normaluser@gmail.com","$2a$10$KKbmpqLRgp7V0KAKE/I01u8F.m5oaQDdpPWJTdDYZG2serbw7J4lK","USER");
        	User adminuser= new User("admin","Adminuser@gmail.com","$2a$10$mCZ/Gvr6ohHUnExdZST6fuLgkI9akogckzmslvspP7DrBUaTcZdny","ADMIN");
        	userrepository.save(normaluser);
        	userrepository.save(adminuser);
        };
    }
}
