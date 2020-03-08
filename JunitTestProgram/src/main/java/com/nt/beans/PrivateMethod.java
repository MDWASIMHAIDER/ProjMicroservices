package com.nt.beans;

public class PrivateMethod {
	
	private String sayHi(String name,String name1) {
		System.out.println("private method called");
		return "hi "+name+" "+name1;
	}
}
