package com.nt.service;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;

public class ContactService {
	
	private ContactDAO dao;

	public ContactDAO getDao() {
		return dao;
	}

	public void setDao(ContactDAO dao) {
		this.dao = dao;
	}
	
	public boolean saveContact(Contact c) {
	
		return dao.save(c);
	}
	public Contact findContactByName(String name) {
		return dao.findByName(name);
	}
}
