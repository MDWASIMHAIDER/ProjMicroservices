package com.nt.servicetest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;
import com.nt.service.ContactService;

@RunWith(MockitoJUnitRunner.class)
public class TestContactService {
	
	@InjectMocks
	private ContactDAO dao;
	
	@InjectMocks
	private ContactService service;
	
	
	@Test
	public void testFindDetail() {
		service.setDao(dao);
		Contact c=service.findContactDetail("wasim");
		System.out.println(c);
		assertNotNull(c);
		
	}
	
}
