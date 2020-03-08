package com.nt.findsecondmin;

public class FindSecondMinAndSecondMaxElement {

	public static void main(String[] args) {
		int []element= {1,2,5,9,6,4,7,2};
		int temp=0;
		int secondMin=0;
		int secondMax=0;
		for(int i=0;i<element.length;i++) {
			for(int j=0;j<element.length;j++) {
				
				if(element[i]<element[j]) {
					temp=element[i];
					element[i]=element[j];
					element[j]=temp;
				}
			}
		}
		secondMin=element[1];
		secondMax=element[element.length-2];
			System.out.println(secondMin+" "+secondMax);
		
	}
	

}
