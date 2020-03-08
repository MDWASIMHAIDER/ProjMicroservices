package com.nt.segregate;

import java.util.Arrays;

public class SeperateZeroAndOne {
	
	public static void main(String [] args) {
		int [] element= {0,1,0,1,0,0,1,1,1,0};
		
		Arrays.sort(element);
		
		for(int i=0;i<element.length;i++) {
			System.out.print(element[i]+",");
		}
	}
}
