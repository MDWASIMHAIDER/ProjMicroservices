package com.nt.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.beans.ContactDetails;

public class ContactTest {
	
	private static ContactDetails cd;
	@BeforeClass
	public static void getContact() {
		System.out.println("before classs");
		cd=new ContactDetails();
	}
	
	
	@Test
	public void test_showContact() {
		
		String msg=cd.showName(101);
		System.out.println("test called "+msg);
	}
	
	@AfterClass
	public static void closeContact() {
		cd=null;
		System.out.println("after class");
	}
}
