package com.nt.java8;

@FunctionalInterface
interface A{
	public int m1(int a,int b);
}

@FunctionalInterface
interface B extends A{
	//public void m1() {}
}
class Demo implements A{

	@Override
	public int m1(int a,int b) {
		System.out.println("Demo.m1() Hello Lambda Exp");
		return 0;
	}
	
}
public class LambdaFunctionalInerface {
	public static void main(String[] atrgs) {
		//B b=same
		A a1=(a,b)-> (a*b);
		int res=a1.m1(10,20);
		System.out.println(res);
		System.out.println(a1.m1(3,20));
		System.out.println(a1.m1(40,2));
	}
}
