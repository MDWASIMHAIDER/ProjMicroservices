package com.nt.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//for without lambda exp
/*class MyComarator implements Comparator<Integer>{

	@Override
	public int compare(Integer obj1, Integer obj2) {
		if(obj1>obj2)
		return -1;
		else if(obj1<obj2)
			return +1;
		else
			return 0;
	}
	
}
*/
public class CustomComaratorWithLambdaExp {

	public static void main(String[] args) {
		ArrayList<Integer>l=new ArrayList<Integer>();
		l.add(25);
		l.add(15);
		l.add(10);
		l.add(20);
		//Collections.sort(l, new MyComarator());
		
		Comparator<Integer> c=(obj1,obj2)->(obj1>obj2)?-1:(obj1<obj2)?1:0;
		Collections.sort(l, c);
		
		//with lambda exp
		/*Collections.sort(l, (obj1,obj2)->{
			//using turnary operator
			return (obj1>obj2)?-1:(obj1<obj2)?1:0;
			if(obj1<obj2)
				return -1;
				else if(obj1>obj2)
					return +1;
				else
					return 0;
		});*/
		System.out.println(l);

	}

}
