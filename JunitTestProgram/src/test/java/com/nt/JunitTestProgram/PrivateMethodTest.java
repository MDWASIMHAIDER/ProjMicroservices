package com.nt.JunitTestProgram;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

import org.junit.Test;


public class PrivateMethodTest {
	//here we are breaking oops concept 
	@Test
	public void test_SayHi() throws Exception {
		String actual=null;
		Class cls=Class.forName("com.nt.beans.PrivateMethod");
		Object obj=cls.newInstance();
		//sayHi is method with two parameters
		Method m=cls.getDeclaredMethod("sayHi",String.class,String.class);
		//allowing accesing private method
		m.setAccessible(true);
		Object objrt=m.invoke(obj, "wasim","haider");
		
		actual=(String) objrt;
		System.out.println("Actual val "+actual);
		assertNotNull(actual);
	}
}
