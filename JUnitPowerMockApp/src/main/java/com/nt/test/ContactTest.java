package com.nt.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.nt.dao.ContactDAO;
import com.nt.model.Contact;
import com.nt.service.ContactService;

import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Testing powermock app
 * */
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="com.nt.service.*")
public class ContactTest{
	
	/**case 1 nnormal member access*/
	@Test
	public void testFindEmail() {
		ContactDAO dao=PowerMockito.mock(ContactDAO.class);
		PowerMockito.when(dao.getNameById(101)).thenReturn(new Contact("wasim",9473442689l));
		when(dao.getNameById(102)).thenReturn(new Contact("bharat",8796567854l));
		
		ContactService service=new ContactService();
		service.setDao(dao);
		Contact c=service.fetcgNameById(101);
		//System.out.println(c);
		Assert.assertNotNull(c);
		/*Contact c1=new Contact();
		c1.setName("wasim");
		c1.setNumber(9473442689l);
		Assert.assertEquals(c, c);
		*/
		
	}//testfindmail
	
	/**case 2 static menber access*/
	@Test
	public void testPrintMessage1() {
		String input="hello";
		String expected="hello wasim";
		
		PowerMockito.mockStatic(ContactService.class);
		PowerMockito.when(ContactService.printMessage1(input)).thenReturn(expected);
		String actual=ContactService.printMessage1(input);
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	/**case 3 private member access*/
	@Test
	public void testPrintMessage2() throws Exception {
		
		ContactService service=PowerMockito.spy(new ContactService());
		
		String actual=org.powermock.reflect.Whitebox.invokeMethod(service,"printMessage2","hi");
		System.out.println(actual);
		assertEquals("hi", actual);
	}
}
