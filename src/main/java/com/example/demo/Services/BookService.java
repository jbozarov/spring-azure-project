package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Book;
import com.sun.el.stream.Optional;

public interface BookService {
	
	List<Book> getBooks(); 	
	
	Book getOneBook(Long id);
	
	void addBook(Book book);
	
	String updateBook(Book book); 
	
	void deleteBook(Long id);
}
