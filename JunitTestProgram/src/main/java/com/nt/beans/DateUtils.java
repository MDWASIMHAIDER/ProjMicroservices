package com.nt.beans;

public class DateUtils {
	
	private static DateUtils d;
	
	private DateUtils() {
		System.out.println("object created");
	}
	
	public static DateUtils DateUtilFactory() {
		if(d==null) {
			d=new DateUtils();
		}
		return d;
	}
}
