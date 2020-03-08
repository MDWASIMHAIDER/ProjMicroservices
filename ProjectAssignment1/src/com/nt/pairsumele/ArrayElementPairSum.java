package com.nt.pairsumele;

import java.util.HashMap;
import java.util.Map;

public class ArrayElementPairSum {
	private String[] pair=new String[6];
	public void findSumPair(int num,int[] element) {
		for(int i=0;i<element.length;i++) {
			for(int j=0;j<element.length;j++) {
				
				if(num==element[i]+element[j]) {
					pair [i]=element[i]+","+element[j];
				}
			}
		}
		Map<Integer,String>map=new HashMap();
		for(int k=0;k<pair.length;k++) {
			if(pair[k]!=null)
			map.put(k,pair[k]);
			

		}
		System.out.println(map);
			}
	
	
	public static void main(String[] args) {
		int [] element= {3,6,8,-8,10,8};
		int temp=0;
		for(int i=0;i<element.length;i++) {
			for(int j=0;j<element.length;j++) {
				
				if(element[i]<element[j]) {
					temp=element[i];
					element[i]=element[j];
					element[j]=temp;
				}
			}
		}
		
		ArrayElementPairSum pair=new ArrayElementPairSum();
		pair.findSumPair(16, element);
		
		
	}
}
