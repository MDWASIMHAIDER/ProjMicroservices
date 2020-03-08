package com.nt.beans;

public class PaySlipGeneratror {
	private Position position;
	private SalaryCalculatorService service;
	
	
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setService(SalaryCalculatorService service) {
		this.service = service;
	}
	
	public void generatePaySlip() {
		if(service==null)
		{
			throw new RuntimeException("service not yet maintained");
		}
		else if(position==null) {
			throw new RuntimeException("Position not yet maintained");
		}
		Double paySlip=service.computeSalary(position);
		System.out.println(paySlip);
	}
}
