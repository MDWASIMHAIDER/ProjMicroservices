package com.nt.printsumofsameelement;

public class PrintSumOfArrayElement {
	
	public static int permutation(int num) {

		int fact=1;
		while(num>0) {
			fact=fact*num;
			num--;
		}
		return fact;
	}
	
	public static int createCombination(int num,int r) {
		int n=permutation(num);
		int dif=num-r;
		int nr=permutation(dif);
		int rfact=permutation(r);
		return n/(nr*rfact);
		
	}
	public static void main(String[] args) {
		int[] element= {4,5,6};
		int r=element.length;
		int rdiff=r-1;
		int n=0;
		n=permutation(3);
		int temp=0;
		int comb=createCombination(element.length,rdiff);
		int[] newArray=new int[element.length];
		int prvs=0;
		for(int i=0;i<comb;i++) {
			for(int j=0;j<element.length;j++) {
			
				if(element[i]!=element[j]) {
					temp=element[j]+element[i];
					if(newArray[i]!=temp)
					newArray[j]=temp;
					temp=0;
					prvs++;
	
				}
			}
		}
		for(int i=0;i<comb;i++) {
			System.out.print(newArray[i]+",");
		}
	}

}


