package swa.lab3.problem1.service;

import java.util.List;

import swa.lab3.problem1.domain.Book;

public interface BookService {
	public Book addBook(Book book);
	public boolean deleteBook(String isbn);
	public Book getBook(String isbn);
	public List<Book> getAllBooks(); 

}
