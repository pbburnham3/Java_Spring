package com.pbburnham3.mvc.services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.pbburnham3.mvc.models.Book;
import com.pbburnham3.mvc.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository) {
	    this.bookRepository = bookRepository;
	}
	
	// returns all the books
	public List<Book> allBooks() {
	    return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book b) {
	    return bookRepository.save(b);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
	    Optional<Book> optionalBook = bookRepository.findById(id);
	    if(optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        return null;
	    }
	}
	
	public Book updateBook(Book book) {
		
		return bookRepository.save(book);
	}
	
	// deletes a book
	public Book deleteBook(Long id) {
		bookRepository.deleteById(id);
		return null;
	}

	
}

