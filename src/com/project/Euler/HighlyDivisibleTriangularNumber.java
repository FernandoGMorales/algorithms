package com.project.Euler;

import java.util.List;

import common.util.algorithms.numberTheory.Divisors;

public class HighlyDivisibleTriangularNumber {
	
	/*
	 * n(n + 1)/2 (sum of the n terms)
	 * 
	 * Solution
	 * 1) Find summation of the n numbers
	 * 2) Find divisors
	 * 
	 */
	
	public static void main(String[] args) {		
		int divCount = 0;
		long  n = 500L;
		long tNum;
		do {
			n+=1;
			tNum = n*(n+1)/2;
			List<Long> divList = Divisors.divisorsOf(tNum);
			divCount = divList.size();
		} while (divCount < 500);
		
		System.out.print(tNum);
	}

}
