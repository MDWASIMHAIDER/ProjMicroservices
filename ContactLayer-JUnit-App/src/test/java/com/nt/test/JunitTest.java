package com.nt.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;
import com.nt.service.ContactService;

//for removing unnecessary stubbing 
@RunWith(MockitoJUnitRunner.Silent.class)
//@RunWith(MockitoJUnitRunner.class)
public class JunitTest {
	
	private static ContactService service;
	private static  Contact c=new Contact("wasim",9473442689l);
	
	private static ContactDAO dao;
	
	@BeforeClass
	public static void m1() throws Exception{
		service=new ContactService();
		ContactDAO dao=mock(ContactDAO.class);
		when(dao.save(c)).thenReturn(true);
		when(dao.findByName("wasim")).thenReturn(new Contact("raju", 1111l));
		when(dao.findByName("bharat")).thenReturn(new Contact("kaju", 22222));
		service.setDao(dao);
	}
	
	@Test
	public void test_save()throws Exception{
		boolean res=service.saveContact(c);
		assertTrue(res);
	}
	
	public void test_findName() {
		Contact c=service.findContactByName("wasif");
		assertNotNull(c);
	}
	
	@AfterClass
	public static void afterClass() {
		service=null;
	}
}
