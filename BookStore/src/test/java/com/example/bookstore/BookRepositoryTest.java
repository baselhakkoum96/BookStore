package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void createBooktest() {
		Book newbook = new Book ("A book for test", "A O", 2023, "123123123", 50, categoryRepository.findByName("Romanse"));
		bookRepository.save(newbook);
		assertThat(newbook.getId()).isNotNull();
	}
	
	@Test
	public void findByTitletest() {
		List<Book> books = bookRepository.findByTitle("A Farewell to Arms");
		assertThat(books).hasSize(1);	
	}
	
	@Test
	@Transactional
	public void deleteBooktest() {
		long deletedbook = bookRepository.deleteByTitle("Animal Farm");
		assertThat(deletedbook).isEqualTo(1);
	}

}
