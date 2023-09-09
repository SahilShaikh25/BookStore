package com.web.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.bookstore.entity.Book;
import com.web.bookstore.entity.MyBookCollection;
import com.web.bookstore.service.BookService;
import com.web.bookstore.service.MyBookCollectionService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookCollectionService mybookservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "BookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAvailableBooks() {
		List<Book> list = service.getAllBooks();
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("BookList");
//		mv.addObject("book", list);
		return new ModelAndView("BookList", "book", list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book){
		service.save(book);
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/myBooks")
	public String getMyBooks(Model model){
		List<MyBookCollection> list = mybookservice.getAllMyBooks();
		model.addAttribute("book",list);
		return "BookCollection";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id){
		Book b = service.getBookById(id);
		MyBookCollection mycol = new MyBookCollection(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mybookservice.saveBooks(mycol);
		return "redirect:/myBooks";
	}
	
	@RequestMapping("/searchPage")
	public String getSearchedPage(){
		return "SearchBook";
	}
	
	@RequestMapping("/search")
	public ModelAndView getSearchedBooks(@RequestParam("name")String name){
		List<Book> list = service.getBooksByName(name);
		return new ModelAndView("SearchedResult", "book", list);
	}
	
	@RequestMapping("/bookEdit/{id}")
	public String bookEdit(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book",b);
		return "BookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
}











