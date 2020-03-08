package com.nt.dao;

import com.nt.model.Contact;

public interface ContactDAO {
	
	public boolean save(Contact contact);

	public Contact findByName(String name);
}
