package com.nt.duplicateword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindDuplicateWord {

	public static void main(String[] args) {
		String str="i am wasim and i am fine";
		String[] split = str.split(" ");
		int count=0;
		Map<String,Integer>map=new HashMap<String,Integer>();
		for(int i=0;i<split.length;i++) {
			
			if(map.get(split[i])!=null)
			{
				map.put(split[i],map.get(split[i])+1);
			}
			else {
				map.put(split[i],1);
			}
		}
		System.out.println(map);
		
		List<Integer>list=new ArrayList<>();
		Set<String> keySet = map.keySet();
		Iterator<String>itr=keySet.iterator();
		while(itr.hasNext()) {
			String next = itr.next();
			if(map.get(next)>1) {
				System.out.println(next+"======="+map.get(next));
			}
		}
		
	}

}
