package com.nt.anagram;

import java.util.Arrays;

/**
 * 
 * 6) Write a java program to find two strings are anagrams to each other or not.

Anagram : Two words are said to be Anagrams of each other if they share the same set of letters to form the respective words.

input1 : silent 
input2 : listen*/
public class FindStringAnagrams {

	public static void main(String[] args) {
		String st1 = "silent";
		String st2 = "listen";
		char[] c1 = st1.toCharArray();
		char[] c2 = st2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		boolean status = false;
		if (st1.length() == st2.length()) {
			status = true;
		}

		if (status) {

			status = Arrays.equals(c1, c2);
		}
		if (status) {
			System.out.println("String are anagrams");
		} else {
			System.out.println("String not anagrams");
		}

	}
}
