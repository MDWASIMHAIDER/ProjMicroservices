package com.nt.java8;

interface A1{
	public void m1();
	public void m2();
	//public void m3();//it create compile time error
	default void m3() {
		System.out.println("A---m3()");
	}
}

public class DefaultMethodsExample implements A1{

	@Override
	public void m1() {
		System.out.println("MethodsExample.m1()");
		
	}
	/*default void m4() {
	allowed only in interface	
	}*/

	@Override
	public void m2() {
		System.out.println("MethodsExample.m2()");
		
	}
	//here we override m3 as public 
	public void m3() {
		System.out.println("DefaultMethodsExample.m3()");
	}
	public static void main(String[] args) {
		DefaultMethodsExample d=new DefaultMethodsExample();
		d.m1();
		d.m2();
		d.m3();
	}
	
}
