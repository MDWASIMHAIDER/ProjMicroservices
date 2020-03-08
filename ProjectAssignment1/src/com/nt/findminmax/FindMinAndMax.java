package com.nt.findminmax;

public class FindMinAndMax {
	
	public static void main(String[] args) {
		int[] element= {1,2,5,5,6,0,6,7,2};
		int lowest=element[0];
		int highest=element[0];
		for(int i=0;i<element.length;i++) {
			for(int j=i;j<element.length;j++) {
				if(element[j]<=lowest) {
					lowest=element[j];
				}
				
				else if(element[j]>=highest){
					highest=element[j];
				}
			}
		}
		System.out.println("highest element in array--> "+highest);
		System.out.println("lowest element in array--> "+lowest);
	}
}
