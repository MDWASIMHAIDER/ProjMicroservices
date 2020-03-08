package com.nt.substringoccurance;


/**
 * 8) Write a java program to read a string and a substring from user. Then write the logic to print the number of times that the substring occurs in the given string. 

Note: String traversal will take place from left to right, not 
from right to left.

Input String : ABCDCDC
Input Sub-String : CDC
Output : 2  
Explantation : CDC occured twice in given string
 * */

public class PrintSubstringOccuranceInString {

	public static void main(String[] args) {
		String str="ABCDCDCDCDCDC";
		int count=0;
		String istr="CDC";
		int len=str.length()/istr.length();
		for(int i=len;i>=0;i--) {
			if(str.contains("CDC"))
				count++;
			
		}
		System.out.println(count);
	}

}
