package com.nt.java8;

public class MatrixAddition {

	public static void main(String[] args) {
		int[][] arr1= {{2,3,4},{5,6,7},{9,8,7}};
		int [][] arr2=new int[3][3];
		int p=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				arr2[i][j]=arr1[i][j]+arr1[p][j];
				System.out.println(arr1[i][j]);
			}
			System.out.println("");
		}
		for(int k=0;k<arr2.length;k++) {
			for(int m=0;m<arr2.length;m++) {
				System.out.println(arr2[k][m]);
			}
			System.out.println("");
		}
		
		
	}

}
