package com.nt.findleader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindLeaderElement {
/* find leader elelemnt from array
 * leader ele appear more than n/2
 * times whwre n i size of array
 * if more than one leade ele then print highest 
 * num fro those,,if no leader in array than print not exist*/
	
	public static void main(String[] args) {
		int[] element= {1,7,4,7,7,7,7,2,2,3,3,4,4,2};
		Map<Integer,Integer>map=new HashMap();

		for(int e:element) {	
		if(map.get(e)!=null) {
				map.put(e, map.get(e)+1);
			}
			else {
				map.put(e,1);
			}
		}
		//Set<Integer> keySet = map.keySet();
		 Integer[] strs = map.keySet().toArray(new Integer[map.size()]);
		System.out.println(map);
		 for(int i=0;i<strs.length;i++) {
			 System.out.println(strs[i]);
		 }
		 int highestEle=strs[strs.length-1];
		 if((element.length/2)< highestEle) {
			System.out.println("leader eleement is "+highestEle); 
		 }
		 else {
			 System.out.println("No leader element is available");
		 }
	}

}
