package com.nt.superelement;

import java.util.Arrays;

public class FindSuperElementInArray {

	public static void main(String[] args) {
		int []element= {1,5,3,6,7,8,9};
		Arrays.sort(element);
		for(int i=0;i<element.length-2;i++) {
			System.out.println(element[i]+" is super element");
		}

	}

}
