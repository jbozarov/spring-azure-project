package com.example.demo.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Book;
import com.example.demo.Services.BookService;

@RestController
@RequestMapping("books")
public class BookController {
	
	private final BookService bookService; 
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// Getting all Books 
	@GetMapping
	public List<Book> getBooks() {
		List<Book> returnValue = bookService.getBooks();   
		return returnValue; 
	}
	
	// Getting single book
	@GetMapping(path="/{id}")
	public Book getOneBook(@PathVariable Long id) {
		Book foundBook = bookService.getOneBook(id); 
		return foundBook; 
	}
	
	// Adding new Book
	@PostMapping
	public void createBook(@RequestBody Book book) {
		bookService.addBook(book); 
	}
	
	// Updating a book
	@PutMapping
	public String updateBook(@RequestBody Book book) {
		System.out.println(book.toString());
		String result = bookService.updateBook(book); 
		return result; 
	}
	
	// Deleting a book 
	@DeleteMapping(path="/{id}")
	public void deteteBook(@PathVariable Long id) {
		bookService.deleteBook(id); 
	}
}
