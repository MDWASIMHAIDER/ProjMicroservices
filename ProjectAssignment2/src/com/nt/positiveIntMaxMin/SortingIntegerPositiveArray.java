package com.nt.positiveIntMaxMin;

public class SortingIntegerPositiveArray {

	public static void main(String[] args) {
		int[]element= {10,20,30,40,50,60,70,80,90,100};
		int[]element2=new int[element.length];
		int old=element.length-1;
		int j=0;
		boolean flag=true;
		for(int i=0;i<element2.length;i++) {

			if(flag)
			element2[i]=element[old--];
			else
			element2[i]=element[j++];
			
			flag=!flag;
		}
		
		for(int i=0;i<element2.length;i++) {
			System.out.print(element2[i]+",");
		}
		//flag=!flag;
		
		/*int high=element.length-1;
		int small=0;
		boolean flag=true;
		for(int i=0;i<element2.length;i++) {
			if(flag)
				element2[i]=element[high--];
			else
				element2[i]=element[small++];
			//j++;
			//old--;
			flag=!flag;
		}*/
		

	}

}
