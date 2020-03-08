package com.nt.findcommanelementarray;

public class FindCommanEleInArray {
	
	public static void main(String[] args) {
		int [] element1= {6,7,20,80,100};
		int [] element2= {1,5,10,20,40,80};
		int [] element3= {3,4,15,20,30,70,80,100};
		int count=0;
		int[] commanEle=new int[element1.length];
		for(int i=0;i<element1.length;i++) {
			for(int j=0;j<element2.length;j++) {
				for(int k=0;k<element3.length;k++) {
					if(element1[i]==element2[j] && element1[i]==element3[k]) {
						commanEle[count]=element3[k];
						count++;
						//System.out.println(commanEle[k]);
					}
				}
			}
			
		}
		for(int i=0;i<commanEle.length;i++) {
			if(commanEle[i]!=0)
			System.out.println(commanEle[i]);

		}
			}
}
