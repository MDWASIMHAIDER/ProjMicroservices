package com.nt.patterns;

public class TrianglePattern {

	public static void main(String[] args) {
		
		int n=4;
		  for (int i=0; i<n; i++) 
	        {   // inner loop to handle number spaces 
	            // values changing acc. to requirement 
	            for (int j=n-i; j>1; j--) 
	            {   // printing spaces 
	                System.out.print(" "); 
	            }
	   
	            //  inner loop to handle number of columns 
	            //  values changing acc. to outer loop 
	            for (int j=0; j<=i; j++ ) 
	            { 
	                // printing stars 
	                System.out.print("* "); 
	            } 
	            // ending line after each row 
	            System.out.println(); 
	        } 
	    } 
	}


