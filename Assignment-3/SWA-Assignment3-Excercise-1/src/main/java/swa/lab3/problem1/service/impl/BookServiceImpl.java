package swa.lab3.problem1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import swa.lab3.problem1.domain.Book;
import swa.lab3.problem1.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	List<Book> bookList = new ArrayList<Book>()
			{
				{
					add(new Book("Book 1", "1213-2323-23234", "Martin Fowler", 12.90));
					add(new Book("Book 2", "4563-2323-23234", "Jason Fowler", 15.90));
				}
			};
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		bookList.add(book);
		return book;
	}

	@Override
	public boolean deleteBook(String isbn) {
		// TODO Auto-generated method stub
		Book book = bookList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
		if(book != null) return bookList.remove(book);
		else return false;
	}

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		return bookList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
		//return new Book("Book 1", "1213-2323-23234", "Martin Fowler", 12.90);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookList;
	}

}
