package com.nt.smallestpair;

public class FindSmallestPairSumElement {

	public static void main(String[] args) {
		int []element= {1,8,3,7};
		int res=0;
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
		
		
		res=element[0]+element[1];
		System.out.println(element[0]+"+"+element[1]+"-->"+res);
	}

}
