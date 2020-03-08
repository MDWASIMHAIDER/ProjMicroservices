package com.nt.duplicateelementinarray;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElementsInArray {

	public static void main(String[] args) {
		int startTime = 0,endTime = 0;
		int[] element = { 1, 2, 5, 5, 6, 6, 7, 2,7 };
		int[] duplicate = new int[element.length];
		startTime = (int) System.nanoTime();
		Set<Integer> set1 = new HashSet();
		Set<Integer> set2 = new HashSet();
		for (int i = 0; i < element.length; i++) {
			if (set1.contains(element[i])) {
				duplicate[i] = element[i];
				set2.add(duplicate[i]);
			}
			set1.add(element[i]);
		}
		endTime = (int) System.nanoTime();
		int diff = endTime - startTime;
		System.out.println(set2);
		System.out.println("Time taken to complete task -> " + diff);

	}

}
