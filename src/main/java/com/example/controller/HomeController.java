package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookModel;
import com.example.repository.BookRepository;

@RestController
public class HomeController {

	@Autowired
	BookRepository BookRepo;
	
	//save a new book
	@PostMapping("/saveBook")
	public void saveBooks(@RequestBody BookModel data) {
		BookRepo.save(data);
	}
	
	//get all the books
	@GetMapping("/getBooks")
	public List<BookModel> getAllBooks(){
		return (List<BookModel>) BookRepo.findAll();
	}
	
	//get by genre
	@GetMapping("/getByType")
	public List<BookModel> getByType(@RequestParam(name= "id") String type){
		return (List<BookModel>) BookRepo.findByGenre(type);
	}
	
	//delete a book
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam(name="bookId") String bookId) {
		BookRepo.deleteById(bookId);
	}
	
	//update a book details
	@PostMapping("/editBook")
	public void editBook(@RequestParam(name="bookId") String bookId,@RequestBody Map<String,Object> data){
		var a  = BookRepo.findById(bookId);
		if(!a.isEmpty()) {
			a.get().setBookName(data.get("bookName").toString());
			a.get().setGenre(data.get("genre").toString());
			a.get().setQuantity(Integer.parseInt(data.get("quantity").toString()));
			BookRepo.save(a.get());
		}
	}
}
