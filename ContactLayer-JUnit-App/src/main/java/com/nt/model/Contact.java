package com.nt.model;

public class Contact {
	private String cName;
	private long cNumber;
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	public Contact(String cName, long cNumber) {
		this.cName = cName;
		this.cNumber = cNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcNumber() {
		return cNumber;
	}
	public void setcNumber(long cNumber) {
		this.cNumber = cNumber;
	}
	@Override
	public String toString() {
		return "Contact [cName=" + cName + ", cNumber=" + cNumber + "]";
	}
	
	
}
