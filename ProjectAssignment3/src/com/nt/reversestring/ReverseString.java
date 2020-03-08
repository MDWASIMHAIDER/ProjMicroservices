package com.nt.reversestring;



/**
 * 1) Write a java program to reverse a String without using reverse() method.

Input : tekleads
Output: sdaelket
 * */
public class ReverseString {
	
	public static void main(String[] args) {
		String s="teaklead";
		char[]s1=s.toCharArray();
		int last=s1.length-1;
		int temp=0;
	
		for(int i=0;i<s1.length/2;i++) {
			temp=s1[i];
			s1[i]=s1[last];
			s1[last]=(char) temp;
			last--;
		}
		String s2=new String(s1);
		System.out.println(s2);
			
	}
}
