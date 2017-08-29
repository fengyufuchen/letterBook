package com.sachin.bl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sachin.bl.service.BookService;

@Controller
public class BookController {

	
	
	@Autowired
	private BookService bookService;
	
	
	
}


