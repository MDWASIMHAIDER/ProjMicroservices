package com.nt.daotest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;


//runner package is depricated so we can use org.mockito.junit.MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class TestContactDAO {
	
	//Mark a field on which injection should be performed.  
	@InjectMocks
	private ContactDAO dao;
	
	@Test
	public void test_findByName() {
		Contact c=dao.findByName("wasim");
		assertNotNull(c);
	}
}
