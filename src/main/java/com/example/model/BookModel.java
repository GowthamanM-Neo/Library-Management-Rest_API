package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookModel {

	@Id
	private String bookId;
	private String bookName;
	private int quantity;
	private String genre;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "BookModel [bookId=" + bookId + ", bookName=" + bookName + ", quantity=" + quantity + ", genre=" + genre
				+ "]";
	}
	
}
