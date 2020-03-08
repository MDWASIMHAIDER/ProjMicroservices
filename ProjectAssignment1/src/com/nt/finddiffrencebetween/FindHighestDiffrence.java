package com.nt.finddiffrencebetween;

public class FindHighestDiffrence {

	public static void main(String[] args) {
		//int[] element= {2,5,1,7,3,9,5};
		int[] element= {9,2,12,5,4,7,3,19,5};
		int diff=0;
		int highest=element[0];
		int lowest=element[0];
		for(int i=0;i<element.length;i++) {
			for(int j=i+1;j<element.length;j++) {
				if(element[j]<=lowest) {
					lowest=element[j];
				}
				
				else if(element[j]>=highest){
					highest=element[j];
				}
			}
		}
		System.out.println(highest+" "+lowest);
		diff=highest-lowest;
		System.out.println(diff);
	}

}
