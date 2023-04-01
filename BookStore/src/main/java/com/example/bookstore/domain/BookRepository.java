package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (path = "books")
public interface BookRepository extends CrudRepository<Book, Long> {
	List <Book> findByTitle (@Param("title") String title);
	long deleteByTitle(String title);
	

}
