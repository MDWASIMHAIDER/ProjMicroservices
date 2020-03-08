package com.example.service;

import org.springframework.stereotype.Service;

import com.example.uexception.UserDefineException;

@Service
public class BookService {
	
	public Double findBookPrice(String bookId) {
		if(bookId.equals("b101")) {
			return 450.98;
		}
		else {
		  throw new UserDefineException("no book found");
		}
	}
}
