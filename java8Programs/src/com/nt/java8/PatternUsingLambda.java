package com.nt.java8;

import java.util.function.Function;

public class PatternUsingLambda {
	
	static Function<Integer, Integer>f1=n->{
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		return 0;
	};
	public static void main(String[] args) {
		f1.apply(5);
		//System.out.println();

	}

}
