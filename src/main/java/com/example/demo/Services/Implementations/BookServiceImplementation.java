package com.example.demo.Services.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Services.BookService;
import com.example.demo.dao.BookRepository;

@Service
public class BookServiceImplementation implements BookService {

	private final BookRepository bookRepository; 
	
	
	public BookServiceImplementation(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@Override
	public List<Book> getBooks() {
		List<Book> returnValue = new ArrayList<Book>(); 
		returnValue = (List<Book>) bookRepository.findAll(); 
		return returnValue; 
	}


	@Override
	public void addBook(Book book) {
		bookRepository.save(book); 
	}


	@Override
	public Book getOneBook(Long id) {
		Optional<Book> foundBook = bookRepository.findById(id);
		Book book =	foundBook.get();
		System.out.print(book.toString());
		return book;
	}


	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}


	@Override
	public String updateBook(Book book) {
		List<Book> returnValue = new ArrayList<Book>(); 
		returnValue = (List<Book>) bookRepository.findAll();
		for(int i =0; i < returnValue.size(); i++) {
			if(returnValue.get(i).getId() == book.getId()) {
				bookRepository.save(book); 	
				return "Book has been updated!"; 
			}
			
		} 
		return "Book is not found"; 
	}
	
	
	

	
	
	
}
