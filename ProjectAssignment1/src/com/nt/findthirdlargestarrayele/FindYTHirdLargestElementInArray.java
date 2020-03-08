package com.nt.findthirdlargestarrayele;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindYTHirdLargestElementInArray {
	
	public static int[] duplicate(int[] arr) {
		int [] array=new int[arr.length];
		int count=0;
		array[0]=arr[0];
		lb:for(int i=0;i<arr.length;i++) {
			lb1:for(int j=0;j<arr.length;j++) {
				if(array[i]!=arr[j]) {
					//array[j]=0;
					//count++;
					array[i]=arr[i];
				}
				else {
					//array[i]=arr[i];
					//count++;
					array[j]=0;
				}
			}
		}
		return array;
	}
	public static void main(String[] args) {
		int [] element= {6,8,1,9,2,1,10,11,11,12,12,17};
		int duplicate[]=new int[element.length];
		int temp=0;
		duplicate=FindYTHirdLargestElementInArray.duplicate(element);
		for(int i=0;i<duplicate.length;i++) {
			for(int j=0;j<duplicate.length;j++) {
				
				if(duplicate[i]>duplicate[j]) {
					if(duplicate[i]==duplicate[j]){
						
					}
					temp=duplicate[i];
					duplicate[i]=duplicate[j];
					duplicate[j]=temp;
				}
			}
		}
		for(int i=0;i<duplicate.length;i++) {
			System.out.print(duplicate[i]+",");
		}
			//System.out.println(duplicate[2]);

		
		/*int largest=0;
		int third=0;
		
		Set<Integer>set=new HashSet();
		Map<String,Integer>map=new HashMap();
		Iterator<Integer>itr=set.iterator();
		int [] thirdLargest=new int[map.size()];
		for(int i=0;i<element.length;i++) {
				//set.add(element[i]);
			map.put(,element[i]);
		}
		for(int i=0;i<map.size();i++) {
			
			
		}
		System.out.println(map);
		*/
		//System.out.println(thirdLargest[0]+" "+thirdLargest[1]);
	
		
	}

}
