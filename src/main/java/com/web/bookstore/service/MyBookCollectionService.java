package com.web.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.bookstore.entity.MyBookCollection;
import com.web.bookstore.repository.MyBookCollectionRepository;

@Service
public class MyBookCollectionService {

	@Autowired
	private MyBookCollectionRepository mybooks;
	
	public void saveBooks(MyBookCollection book) {
		mybooks.save(book);
	}
	
	public List<MyBookCollection> getAllMyBooks(){
		return mybooks.findAll();
	}
	
	public void deleteById(int id){
		mybooks.deleteById(id);
	}
}
