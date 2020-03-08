package com.nt.reverseeachword;

import java.util.HashMap;
import java.util.Map;

/**
 * 2) Write a java program to reverse each word of a String

input : java programming language

output : avaj gnimmargorp egaugnal

 * */

public class ReverseEachWordOFString {

	public static void main(String[] args) {
		String str="java programming language";
		String[]st=str.split(" ");
		Map<Integer,String>map=new HashMap();
		for(int i=0;i<st.length;i++) {
			map.put(i,st[i]);
		}
		char temp=' ';
		int last=0;
		char[]c=null;
		for(int i=0;i<map.size();i++) {
			String s=map.get(i);
			c=s.toCharArray();
			last=c.length-1;
			for(int j=0;j<c.length/2;j++) {
				temp=c[j];
				c[j]=c[last];
				c[last]=(char) temp;
				last--;
	
			}
			String s1=new String(c);
			map.put(i,s1);
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<map.size();i++) {
			sb.append(" "+map.get(i));
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*char[]s1=str.toCharArray();
		
		 * char temp=' ';
		int len=0;
		int last=s1.length-1;
		for(int i=0;i<len;i++) {
			if(s1[i]!=' ') {
				temp=s1[i];
				s1[i]=s1[last];
				s1[last]=(char) temp;
				last--;
			}
			
		}
		
		for(int i=0;i<s1.length;i++) {
		
			System.out.print(s1[i]+",");
		}
		
		
		
		
		*/
		
		
		
		
		//String[] arr=str.split(" ");
		//int len=0;
		//String temp=null;
		//int last=0;
		//char[]revWord=word.toCharArray();
		
		/*for(int i=0;i<arr.length;i++) {
			len=arr[i].length();
			last=arr[i].length()-1;
			
			if(arr[i].length()<len) {
				for(int j=0;j<len/2;j++) {
					temp=arr[i];
					arr[i]=arr[last];
					arr[last]=temp;
					last--;
				}
				len--;
			}
			System.out.print(c[i]);
		}*/
		

	}

}
