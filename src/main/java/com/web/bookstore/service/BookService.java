package com.web.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.bookstore.entity.Book;
import com.web.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository brepo;
	
	public void save(Book book) {
		brepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return brepo.findAll();
	}
	
	public Book getBookById(int id) {
		return brepo.findById(id).get();
	}
	
	public List<Book> getBooksByName(String key){
		return (List<Book>) brepo.findByName(key);
	}
	
	public void deleteById(int id) {
		brepo.deleteById(id);
	}
}
