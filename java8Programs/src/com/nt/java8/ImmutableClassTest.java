package com.nt.java8;

public final class ImmutableClassTest {

	private String val;
	public ImmutableClassTest(String val) {
		this.val=val;
	}
	
	public ImmutableClassTest modifyVal(String value) {
		if(this.val==value) {
			return this;
		}
		else {
			return (new ImmutableClassTest(value));
		}
	}

	public static void main(String[] args) {
		ImmutableClassTest test=new ImmutableClassTest("wasim");
		//ImmutableClassTest test1=new ImmutableClassTest(10);
		ImmutableClassTest test1=test.modifyVal("WASIM");
		System.out.println(test==test1);
		System.out.println(test.hashCode()+"----"+test1.hashCode());

	}

}
