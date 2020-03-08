package com.nt.service;

import com.nt.dao.ContactDAO;

public class ContactServiceImpl implements ContactService {
	
	private ContactDAO dao;

	public void setDao(ContactDAO dao) {
		this.dao = dao;
	}

	public String findMailById(int id) {
		String name=dao.findEmailById(id);
		return name;
	}


}
