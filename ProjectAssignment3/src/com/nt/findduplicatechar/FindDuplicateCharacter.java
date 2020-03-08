package com.nt.findduplicatechar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 3) Write a java program to find occurance of duplicate character in given String. If there is no duplicate character in given String it should print 'No Duplicates Found'.

input : java 
output : a-2
Explanation : a-occured 2 times

input : madam
output: m-2 & a-2
Explanation : m occured two times & a occured 2 times

 * *
 * @author wasim
 *
 */
public class FindDuplicateCharacter {

	public static void main(String[] args) {
		String st="javajv";
		//char[]c=st.toCharArray();
		Map<Character,Integer>map=new HashMap();
		for(int i=0;i<st.length();i++) {
			char c=st.charAt(i);
			if(map.get(c)!=null) {
			map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		
		Iterator itr=map.keySet().iterator();
		while(itr.hasNext()) {
			char s=(char) itr.next();
			if(map.get(s)>1) {
				System.out.println(s+"-> duplicate and occurance of char is "+map.get(s));
				//break;
			}
			else {
				System.out.println("Duplicate not found");
				break;
			}
		}
		
		System.out.println(map);

	}

}
