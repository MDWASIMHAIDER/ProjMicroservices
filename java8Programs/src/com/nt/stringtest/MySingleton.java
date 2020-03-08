package com.nt.stringtest;

public class MySingleton {
	
	int count=0;
	private static MySingleton ms=null;
	private MySingleton() {
		count++;
		System.out.println("obj created"+count);
	}
	public static MySingleton getMySingleton() {
		if(ms==null) {
			return ms=new MySingleton();
		}
		else {
		return ms;
		}
	}
	public static void main(String[] args) {
		//MySingleton mst=new MySingleton();
		//MySingleton mst1=new MySingleton();
		MySingleton ms1=MySingleton.getMySingleton();
		MySingleton ms2=MySingleton.getMySingleton();
		System.out.println(ms1.hashCode()+"==="+ms2.hashCode());
				

	}

}
