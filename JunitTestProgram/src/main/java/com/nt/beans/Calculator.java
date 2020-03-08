package com.nt.beans;

public class Calculator {
	
	
	public Integer add(Integer a,Integer b) {
		return a+b;
	}
	
	public Integer div(Integer a,Integer b) {
		return a/b;
	}
	
	public void mail() {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
