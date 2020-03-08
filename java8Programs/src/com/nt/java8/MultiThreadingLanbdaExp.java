package com.nt.java8;

public class MultiThreadingLanbdaExp {

	public static void main(String[] args) {
		Runnable r=()->{
			for(int i=0;i<10;i++) {
				System.out.println("child Thread");
			}
		};//here semicolon is mandatory
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("main Thread");
		}
	}

}
