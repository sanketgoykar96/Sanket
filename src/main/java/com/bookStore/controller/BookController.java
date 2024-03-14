package com.bookStore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
		ModelAndView m = new ModelAndView();
		m.setViewName("bookList");
		m.addObject("book",list);
		return m;
		
	}
//	@PostMapping("/save")
//	public String addBook(@ModelAttribute Book b) {
//		service.save(b);
//		return "redirect:/available_books";
//	}
	
	
}
