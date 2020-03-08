package com.nt.service;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;

public class ContactService {
	private ContactDAO dao;
	
	public void setDao(ContactDAO dao) {
		this.dao = dao;
	}

	public Contact fetcgNameById(final int id) {
		Contact c=dao.getNameById(id);
		return c;
	}
	
	public static String printMessage1(String message) {
		System.out.println("static method called");
		return message;
	}

	private String printMessage2(String message) {
		System.out.println("private method called");
		return message;
	}
}
