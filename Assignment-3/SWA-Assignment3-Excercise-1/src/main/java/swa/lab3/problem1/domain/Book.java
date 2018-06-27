package swa.lab3.problem1.domain;

public class Book {
	private String title;
	private String isbn;
	private String author;	
	private Double price;
	public Book() {
		
	}
	public Book(String title, String isbn, String author, Double price) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getAuthor() {
		return author;
	}
	public Double getPrice() {
		return price;
	}



}
