package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String>{

	List<BookModel> findByGenre(String type);


}
