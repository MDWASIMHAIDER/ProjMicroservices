package com.example.demo.test;

import org.springframework.stereotype.Component;

//@Component("test")
@Component()
public class Testing {
	//we have to follow basepackage naming convention
	public Testing() {
		System.out.println("test constructor called");
	}
	public void m1() {
		System.out.println("Welcome Wasim");
	}

}
