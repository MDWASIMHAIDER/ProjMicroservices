package com.nt.leftrepos;

import java.util.Scanner;

public class RepositionArrayElement {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//int[] element= {1,2,3,4,5,6,7};
		
		System.out.println("Enter length of array");
		int size=sc.nextInt();
		int[] element=new int[size];
		for(int i=0;i<size;i++) {
			System.out.println("enter element for array "+i+" postion");
			element[i]=sc.nextInt();
		}
		
		System.out.println("Enter Element postion You want to reposition");
		
		int repos=sc.nextInt();
		int j=0;
		int []element2=new int[element.length];
	
		for(int i=element.length-1;i>repos;i--) {
				element2[j++]=element[i];
				
		}
		
		for(int i=0;i<=repos;i++) {
			element2[j++]=element[i];

		}
		for(int i=0;i<element2.length;i++) {
		System.out.println(element2[i]);

		}
		
	}

}
