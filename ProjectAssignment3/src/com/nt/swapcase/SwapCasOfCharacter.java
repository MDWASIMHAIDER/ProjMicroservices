package com.nt.swapcase;


/**
 * 9) Write a java program to swap cases of characters in given string (Convert lowercase character to uppercase character and vise versa)

input : Www.TekLeads.com
output : wWW.tEKlEADS.COM
 * */
public class SwapCasOfCharacter {

	public static void main(String[] args) {
		
		String st="Www.TekLeads.com";
		char[] ch=st.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(Character.isUpperCase(ch[i])) {
				ch[i]=Character.toLowerCase(ch[i]);
			}
			else {
				ch[i]=Character.toUpperCase(ch[i]);
			}
		}
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}


	}

}
