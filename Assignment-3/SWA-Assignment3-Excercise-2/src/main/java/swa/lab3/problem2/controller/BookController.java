package swa.lab3.problem2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swa.lab3.problem2.domain.Book;
import swa.lab3.problem2.error.NotFoundError;
import swa.lab3.problem2.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;

	@RequestMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping("/get/{isbn}")
	public ResponseEntity<?> getGreeting(@PathVariable("isbn") String isbn){
		Book book = bookService.getBook(isbn);
		if (book != null)
		return new ResponseEntity<Book>(book,  HttpStatus.OK );
		else 
			return new ResponseEntity<NotFoundError>(new NotFoundError("no book found"), HttpStatus.NOT_FOUND);
	}
		
	@PostMapping("/add")
	public ResponseEntity<?> addBook( @RequestBody Book book){
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn){
		
		boolean isRemove = bookService.deleteBook(isbn);
		if(isRemove)
		return new ResponseEntity<String>(new String("deleted"), HttpStatus.OK);
		else return new ResponseEntity<NotFoundError>(new NotFoundError("no book found"), HttpStatus.NOT_FOUND);
	}
}
