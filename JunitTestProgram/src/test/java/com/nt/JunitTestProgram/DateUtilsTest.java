package com.nt.JunitTestProgram;

import static org.junit.Assert.assertSame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.beans.DateUtils;

public class DateUtilsTest {
	
	private static DateUtils d1,d2;
	
	@BeforeClass
	public static void createDateObj() {
		d1=DateUtils.DateUtilFactory();
		d2=DateUtils.DateUtilFactory();
	}
	
	@Test
	public void test_DateUtilFactory() {
		
		if(d1.hashCode()==d2.hashCode())
			System.out.println("only one obj created");
		assertSame(d1, d2);
	}
	
	@Test
	public void test_DateUtilFactory1() {
		
		if(d1.hashCode()!=d2.hashCode())
			System.out.println("two obj created");
		System.out.println("only one obj created");
		assertSame(d1, d2);
	}
	
	@AfterClass
	public static void closeObj() {
		System.out.println("aftr class");
		d1=null;
		d2=null;
		
	}
}
