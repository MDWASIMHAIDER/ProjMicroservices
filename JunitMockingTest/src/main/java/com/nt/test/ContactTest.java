package com.nt.test;


import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.dao.ContactDAO;
import com.nt.service.ContactService;
import com.nt.service.ContactServiceImpl;




public class ContactTest{
	
	 ContactService service;
	
	
	/*@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		service=new ContactServiceImpl();
	}*/
	
	/*@BeforeClass
	public static void test_mail() {
		service=new ContactServiceImpl();

	}*/
	
	@Test
	public void test_Findmail() {
		service=new ContactServiceImpl();
		ContactDAO dao=EasyMock.createMock(ContactDAO.class); 
		//ContactService service=new ContactServiceImpl();
		EasyMock.expect(dao.findEmailById(101)).andReturn("john");
		EasyMock.expect(dao.findEmailById(102)).andReturn("wasim");
		
		EasyMock.replay(dao);
		((ContactServiceImpl) service).setDao(dao);
		String res=service.findMailById(101);
		assertEquals("john",res);
		
	}
	
	
	
}
