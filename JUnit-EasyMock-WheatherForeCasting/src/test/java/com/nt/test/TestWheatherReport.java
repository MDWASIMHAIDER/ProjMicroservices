package com.nt.test;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Test;

import com.nt.beans.IWeatherForeCasting;
import com.nt.beans.WheatherReportGenerator;

import junit.framework.TestCase;

public class TestWheatherReport extends TestCase{
	
	private IWeatherForeCasting fcast;
	private WheatherReportGenerator report;
	
	
	//this one is TestCase method defaul 
	@Override
	public void setUp() {
		System.out.println("in setup");
		report=new WheatherReportGenerator();
		fcast=EasyMock.createMock(IWeatherForeCasting.class);
		EasyMock.expect(fcast.getTemprature(812001)).andReturn(37.2);
		EasyMock.expect(fcast.getTemprature(500016)).andReturn(26.33);
		EasyMock.replay(fcast);
		report.setWeather(fcast);
	}
	
	@Test
	public void testGenerateTemprature() {
		
		double res=report.generateTemprature(500016);
		assertEquals(26.33, res);
		System.out.println(res);
	}
	
	
}
