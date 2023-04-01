package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.controller.BookController;
import com.example.bookstore.controller.RESTController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookStoreTests {
	
	@Autowired
	private BookController bookController;
	@Autowired
	private RESTController restController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(restController).isNotNull();
	}

}
