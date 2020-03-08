package com.nt.removeduplicate;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateElementInArray {

	public static void main(String[] args) {
		int start=0;
		int end=0;
		start=(int) System.nanoTime();
		int [] element= {1,2,5,5,5,6,7,2};
		Set<Integer>set=new HashSet();
		for(int i=0;i<element.length;i++) {
			set.add(element[i]);
		}
		end=(int) System.nanoTime();
		int diff=end-start;
		System.out.println(set);
		System.out.println("time taken to porcess-> "+diff);
		
	
	}

}
