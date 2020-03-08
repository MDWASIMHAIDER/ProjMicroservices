package com.nt.JunitTestProgram;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.nt.beans.Calculator;

public class MainTest {
	
	public static void main(String [] args) {
		//running unit test class
		Result result = JUnitCore.runClasses(Calculator.class);
		
		//getting total run count
		int totalCount=result.getRunCount();
		System.out.println("total count run "+totalCount);
		
		//getting total fail count 
		int failureCount=result.getFailureCount();
		System.out.println("total fail count "+failureCount);
		
		//getting failure reason message
		List<Failure>failure=result.getFailures();
		for(Failure f:failure) {
			System.out.println(f);
		}
		
	}
}
