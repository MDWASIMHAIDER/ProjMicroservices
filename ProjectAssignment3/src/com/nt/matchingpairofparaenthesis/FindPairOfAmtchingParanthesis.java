package com.nt.matchingpairofparaenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 7) write a java program that can check given string has matching pair of
 * parentheses or not.
 * 
 * Ex : () has matching parenthesis, but (() doesn’t
 * 
 * Input : [()]{}{[()()]()} Output : Matching 40,41 Input: [(]) Output: Not
 * Matching
 */
public class FindPairOfAmtchingParanthesis {

	public static void main(String[] args) {
		String str = "[()]{}({[()()]()()()}";
		int[] ele = new int[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 40 || str.charAt(i) == 41)
				ele[i] = (int) str.charAt(i);

		}
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < ele.length; i++) {
			if (ele[i] != 0 && ele[i] == 40) {
				count1++;
			} else if (ele[i] != 0 && ele[i] == 41) {
				count2++;
			}
		
		}
		if (count1 == count2)
			System.out.println("match found");
		else
			System.out.println("match not found");
	}

}
