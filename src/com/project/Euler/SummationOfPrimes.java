package com.project.Euler;

import common.util.algorithms.numberTheory.SieveOfEratosthenes;

public class SummationOfPrimes {
	
	/**
	 * Problem:
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	   Find the sum of all the primes below two million.
	   
	 * @param args
	 */
	public static void main(String[] args) {		
		boolean[] primes = SieveOfEratosthenes.sieve(2_000_000);
		long sum = 0;
		for(int i=2; i<primes.length; i++) {
			if(!primes[i]) {
				sum+=(long)i;
			}
		}
		System.out.print(sum);
	}

}
