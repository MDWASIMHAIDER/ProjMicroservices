package com.nt.JunitTestProgram;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.nt.beans.Calculator;

import junit.framework.Assert;

public class ClaculatorTest {
	
	private static Calculator c;
	
	@BeforeClass
	public static void m1() {
		System.out.println("before class");
		c=new Calculator();	
	}
	
	@Test
	public void test_Add() {
		System.out.println("test add");
		int actual=c.add(10, 20);
		Assert.assertEquals(30, actual);
	}
	
	//@Test
	@Ignore
	public void test_div() {
		System.out.println("test div");
		int actual=c.div(12,3);
		Assert.assertEquals(4, actual);
	}
	
	@Test(expected=ArithmeticException.class)
	public void test_div2() {
		System.out.println("test div2");
		c.div(10, 0);
		
	}
	
	@Ignore
	public void test_mail() {
		
	}
	
	@Test(timeout=3100)
	public void test_findMail() {
		System.out.println("fime mail with timeout 3 sec");
		c.mail();
	}
	
	@AfterClass
	public static void close() {
		System.out.println("after class");
		c=null;
	}
}
