package swa.lab3.problem2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swa.lab3.problem2.domain.Book;
import swa.lab3.problem2.repository.BookRepository;
import swa.lab3.problem2.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public boolean deleteBook(String isbn) {
		Book book = bookRepository.findById(isbn).orElse(null);
		if(book != null) {
			bookRepository.delete(book);
			return true;
		}
		else return false;
	}

	@Override
	public Book getBook(String isbn) {
		return bookRepository.findById(isbn).orElse(null);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
