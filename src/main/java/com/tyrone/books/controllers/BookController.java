package com.tyrone.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tyrone.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService; // Does dependency injection automatically saving lines of code
	
	
//	 @GetMapping("/books/{bookId}") 
//	 public String index(@PathVariable("bookId")Long bookId) { 
//	 System.out.println(bookId);
//	 return "index.jsp"; }
//	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId")Long bookId) {
		
		model.addAttribute("book", bookService.findBook(bookId));
		
		return "show.jsp";
	}

}
