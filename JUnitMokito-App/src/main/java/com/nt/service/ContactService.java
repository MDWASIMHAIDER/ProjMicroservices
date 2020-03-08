package com.nt.service;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;

public class ContactService {
	
	private ContactDAO dao;

	public void setDao(ContactDAO dao) {
		this.dao = dao;
	}
	
	public Contact findContactDetail(String name) {
		System.out.println("find contact detail");
		Contact c=dao.findByName(name);
				return c;
	}
}
