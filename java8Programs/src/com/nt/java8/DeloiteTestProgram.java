package com.nt.java8;

public class DeloiteTestProgram {
	
	public int[] convertedValue(int num) {
		int[] array1= {0,1,2,3,4,5,6,7,8,9};
		int[] array2= {9,8,7,6,5,4,3,2,1,0};
		
		int r1=0,r2=0,r3=0,q1=0,q2=0,q3=0;
		q1=num/100;//generate quosent
		r1=num%100;//reminder
		q2=r1/10;//6
		r2=r1%10;//5
		q3=q1/10;//2
		r3=q1%10;//5
		int[] numArray= {q3,r3,q2,r2};
		for(int i=0;i<numArray.length;i++) {
			for(int j=0;j<array1.length;j++) {
				if(numArray[i]==array1[j]) {
					numArray[i]=array2[j];
					break;
				}
			}
		}
		
		return numArray;
	}
	public static void main(String[] args) {
		DeloiteTestProgram dtp=new DeloiteTestProgram();
		int[] ar=dtp.convertedValue(2565);
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+",");
		}
	}

}
