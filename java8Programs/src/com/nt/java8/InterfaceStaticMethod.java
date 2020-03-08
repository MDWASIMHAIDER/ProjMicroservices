package com.nt.java8;


 interface StaticInterface{
	public static void m1() {
		System.out.println(" interface static method called");
	}
}
public class InterfaceStaticMethod implements StaticInterface{
	
	/*public static void m1() {
		System.out.println("implementation changed");
	}*/
	public static void main(String[] args) {
		StaticInterface.m1();
		InterfaceStaticMethod si=new InterfaceStaticMethod();
		//si.m1();
		//m1();
	}
}
