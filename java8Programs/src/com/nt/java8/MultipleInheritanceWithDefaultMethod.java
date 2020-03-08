package com.nt.java8;

interface Right{
	default void m1() {
		System.out.println("right.m1()");
	}
}
interface Left{
	default void m1() {
		System.out.println("Left.m1()");
	}
}

public class MultipleInheritanceWithDefaultMethod implements Right,Left{

	@Override
	public void m1() {
	//explicitly choose to call which interface method
		
		//System.out.println("MultipleInheritanceWithDefaultMethod.m1()");
		Left.super.m1();
		//Right.super.m1();
	}
	
	public static void main(String[] args) {
		MultipleInheritanceWithDefaultMethod d=new MultipleInheritanceWithDefaultMethod();
		//d.m1();//to call our own m1 implemetation
		d.m1();//to call specific interface method
	}
	
}
