package com.nt.printreverseiterration;

public class PrintReverseArrayAfterFirtIteration {

	public static int[] reverseArray(int [] array,int count){
		int[] temp=new int[array.length];
		int ele=0;
		ele=array.length-1;
		for(int i=0;i<array.length;i++){
			//System.out.println(array[i]);
			temp[i]=array[ele];
			ele--;
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] element= {1,2,3,4,5,6};
		int []temp=new int[element.length];
		int ele=0;
		ele=element.length-1;
		int count=0;
		for(int i=0;i<element.length;i++) {
			if(count!=element.length) {
				System.out.print(element[i]);
				count++;
			}
		
			temp[i]=element[ele];
			ele--;
		}
		System.out.println("");
		
		count=temp.length-1;
		//temp=reverseArray(temp);
		for(int i=0;i<temp.length;i++) {
			for(int j=i;j<temp.length-1;j++) {
				System.out.print(temp[j]);
			}
			count--;
			System.out.println("");
			temp=reverseArray(temp,count);
			
		}
	}

}
