package com.coderbyte.challenges.easy;

public class FirstFactorial {
	
	public static int firstFactorial(int num) {
		if(num==0 || num==1) {
	    	return 1;
	    }
		return num*firstFactorial(num-1);		
	  } 

	public static void main(String[] args) {		
		System.out.println("Factorial of 13  is :" + firstFactorial(13));
	}
	
}
