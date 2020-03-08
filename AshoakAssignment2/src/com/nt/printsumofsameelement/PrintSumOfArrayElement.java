package com.nt.printsumofsameelement;

public class PrintSumOfArrayElement {
	
	public static int permutation(int num) {
		int i=0;
		int fact=1;
		while(num>0) {
			fact=fact*num;
			num--;
		}
		return fact;
	}
	public static void main(String[] args) {
		int n=0;
		n=permutation(4);
		System.out.println(n);
		/*int[] element= {4,5,6};
		for(int i=0;i<element.length;i++) {
			for(int j=0;j<element.length;j++) {
				int res=fact(element[j]);
			}
		}

	}
*/
}
}
