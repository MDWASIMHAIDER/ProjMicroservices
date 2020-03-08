package com.nt.beans;


import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



import junit.framework.TestCase;

public class SalaryCalculatorServiceTest extends TestCase{
	private PaySlipGeneratror paySlipGenratror;
	private SalaryCalculatorService salCalcService;

	@Before
	protected void setUp() throws Exception {
		System.out.println("in setup");
		paySlipGenratror = new PaySlipGeneratror();
		salCalcService = EasyMock.createMock(SalaryCalculatorService.class);
	}
	
	@Test
	public void testComputeSalary(){
		EasyMock.expect(salCalcService.computeSalary(Position.DEVELOPER)).andReturn(45000.00);
		EasyMock.expect(salCalcService.computeSalary(Position.TESTER)).andReturn(35000.00);
		EasyMock.expect(salCalcService.computeSalary(Position.MANAGER)).andReturn(80000.00);
		EasyMock.replay(salCalcService);
		paySlipGenratror.setPosition(Position.DEVELOPER);
		paySlipGenratror.setService(salCalcService);
		paySlipGenratror.generatePaySlip();
	}

    @After
	protected void tearDown() throws Exception {
		System.out.println("in teardown");
	}

}
