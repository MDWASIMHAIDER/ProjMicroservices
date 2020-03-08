package com.nt.findfirstnonrepaeatchar;

import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 4) Write a java program to find first non-repeated character from given String

input : simplest
ouput : i
 * */
public class FindFirstNonRepeatedCharcter {
	
	public static void main(String[] args) {
		String st="simplest";
		boolean b;
		for(int i=0;i<st.length();i++) {
			b=true;
			for(int j=0;j<st.length();j++) {
				//i!j says cant cpmpare with same ele
				if(i!=j && st.charAt(i)==st.charAt(j)) {
					b=false;
					break;
				}
			}
			if(b) {
				System.out.println(st.charAt(i));
				break;
			}
		}
	}

}
