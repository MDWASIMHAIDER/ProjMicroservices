package com.nt.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapPutUsingLambda {

	public static void main(String[] args) {
		Map<String, String>map=new HashMap<String, String>();
		
		Function<String,Boolean>f1=val->{
			int i=0;
			map.put(val,val);
			//i++;
			return true;
		};
		System.out.println(f1.apply("hidayat"));
		System.out.println(map);
		System.out.println(f1.apply("wasim"));
		System.out.println(map);

	}

}
