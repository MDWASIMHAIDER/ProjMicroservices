package com.nt.removespecialcharacter;


/**
 * 5) Write a java program to remove all special characters from given String

input : $ja!va$&st%ar
output : javastar
 * */
public class RemoveSpecialCharacterFromString {

	public static void main(String[] args) {
		String str="$ja!va$&st%ar";
		int pos=0;
		char[] ch=new char[str.length()];
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>=97 && str.charAt(i)<122) {
				ch[pos++]=str.charAt(i);
			}
		}
		String s=new String(ch);
		System.out.println(ch);
	}

}
