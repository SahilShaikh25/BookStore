package com.web.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.bookstore.service.MyBookCollectionService;

@Controller
public class MyBookCollectionController {
	
	@Autowired
	private MyBookCollectionService mybookcolservice;
	
	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id){
		mybookcolservice.deleteById(id);
		return "redirect:/myBooks";
	}
}
