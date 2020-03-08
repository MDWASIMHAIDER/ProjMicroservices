package com.nt.sumofuniqueelement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SumOFUniqueElementInArray {

	public static void main(String[] args) {
		int [] element= {1,6,4,3,2,2,3,8,1};
		//int [] element= {1,1,3,2,2,3};
		Set<Integer>set=new HashSet();
		Integer it=0;
		for(int i=0;i<element.length;i++) {
			set.add(element[i]);
		}
		Iterator<Integer>itr=set.iterator();
		while(itr.hasNext()) {
			it+=itr.next();
		}
		System.out.println(set+"\n"+it);
		
	}
}
