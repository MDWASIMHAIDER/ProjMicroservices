package com.nt.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamStringLenthCheck {

	public static void main(String[] args) {
		ArrayList<String>l=new ArrayList<String>();
		l.add("pawan");
		l.add("ravi");
		l.add("chiranjeeve");
		l.add("venkatesh");
		l.add("nagarguna");
		System.out.println(l);
		//List<String>l1= l.stream().filter(n->n.length()<=5).collect(Collectors.toList());
		Predicate<String>p1=n->n.length()<=5;
		List<String>l1=l.stream().filter(p1).collect(Collectors.toList());
		System.out.println(l1);
	}

}
