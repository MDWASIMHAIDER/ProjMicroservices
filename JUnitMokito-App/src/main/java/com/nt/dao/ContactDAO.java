package com.nt.dao;

import com.nt.model.Contact;

public class ContactDAO {
	
	public Contact findByName(String name) {
		Contact c=new Contact("wasim",9473442689l);
		return c;
	}
}
