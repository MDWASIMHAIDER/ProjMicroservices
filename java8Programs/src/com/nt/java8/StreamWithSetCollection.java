package com.nt.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamWithSetCollection {

	public static void main(String[] args) {
		//HashSet<Integer>set=new HashSet();
		ArrayList<Integer>set=new ArrayList();
		set.add(6);
		set.add(2);
		set.add(10);
		set.add(8);
		set.add(11);
		System.out.println(set);
		Function<Integer, Integer>f1=i->i*2;
		//Set<Integer> set2 = set.stream().filter(i->i%2==0).collect(Collectors.toSet());
		//System.out.println(set2);
		List<Integer> set3 = set.stream().map(f1).collect(Collectors.toList());
		System.out.println(set3);
		Set<Integer> set4 = set.stream().sorted().collect(Collectors.toSet());
		System.out.println(set4);
		
	}

}
