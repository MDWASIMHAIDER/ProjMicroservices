package com.nt.wraptoparagraph;



/**
 * 10) Write a java program to read String s and width w. Then implement logic to wrap String text into paragraph of width w.

input : ABCDEFGHIJKLIMNOQRSTUVWXYZ
width : 4

Output : 
ABCD
EFGH
IJKL
 * */
public class StringTextIntoParagraph {

	public static void main(String[] args) {
		String st="ABCDEFGHIJKLIMNOQRSTUVWXYZ";
		int width=4;
		int increase=4;
		if(st.length()>4) {
			for(int i=0;i<st.length();i++) {
				if(i==width) {
					System.out.println("");
					width=width+increase;
					//increase++;
				}
				
				//else
				System.out.print(st.charAt(i));
				
			}
		}
		else {
			System.out.println("String size cant be less than 4");
		}

	}

}
