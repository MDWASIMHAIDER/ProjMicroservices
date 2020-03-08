package com.nt.zeroonetwo;

import java.util.Arrays;

public class ArrangeZeroOneTwo {

	public static void main(String[] args) {
		int[] element= {0,1,0,2,0,0,2,1,2,0};
		Arrays.sort(element);
		for(int i=0;i<element.length;i++) {
			System.out.print(element[i]+",");
		}

	}

}
