package com.example.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller

public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catgoryRepository;

	@GetMapping("/index")
	public String book(Model model) {
		return "index";
	}
	
	@GetMapping(value="/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/booklist")
	public String bookList(Model model, Authentication authentication) {
		model.addAttribute("books", repository.findAll());
		model.addAttribute("username", authentication.getName());
		return "booklist";
	}

	@GetMapping("/add")
	public String addBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catgoryRepository.findAll());

		return "addbook";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}

	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", catgoryRepository.findAll());
		return "editbook";
	}

	@PostMapping(value="/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

}
