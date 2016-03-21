package com.project.Euler;

import java.util.List;

import common.util.algorithms.numberTheory.Divisors;
import common.util.algorithms.numberTheory.PrimalityTest;

public class LargestPrimeFactor {
	
	/**
	 * Problem:
	 * The prime factors of 13195 are 5, 7, 13 and 29.
		What is the largest prime factor of the number 600851475143 ?
	 * 
	 * Solution:
	 * 1) Find factors of n
	 * 2) Find the max prime factor of n 
	 * 
	 * @param n
	 * @return
	 */
	public static void main(String[] args) {
		long n = 600851475143L;
		List<Long> divisors = Divisors.divisorsOf(n);
		for(int i=divisors.size()-1; i>=2; i--) {
			long factor = divisors.get(i);
			if(PrimalityTest.isPrime(factor)) {
				System.out.println("Largest prime factor of " + n + " is: " + factor);
				break;
			}
		}
	}
	

}
