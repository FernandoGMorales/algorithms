package com.project.Euler;

import java.math.BigInteger;

public class PowerDigitSum {
	
	public static void main(String[] args) {
		BigInteger result = BigInteger.ZERO;
		BigInteger number = BigInteger.valueOf(2);
		number = number.pow(1000);		 
		while (number.compareTo(BigInteger.ZERO)==1) {
		    result = result.add(number.mod(BigInteger.TEN));
		    number = number.divide(BigInteger.TEN);
		}
		System.out.print(result);
	}

}
