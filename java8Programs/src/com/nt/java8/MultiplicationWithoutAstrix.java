package com.nt.java8;

import java.util.function.Function;

public class MultiplicationWithoutAstrix {

	public static void main(String[] args) {
		
		Function<Integer, Integer[]>f1=(i)->{
			int mul=0;
			Integer[] res=new Integer[10];
			for(int j=0;j<10;j++) {
				
				mul=mul+i;
				res[j]=mul;
				//System.out.println(mul);
			}
			return res;
		};
		
		Integer[] apply = f1.apply(3);
		for(int i=0;i<10;i++) {
			System.out.println(apply[i]);
		}
	}

}
