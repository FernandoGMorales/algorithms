package com.project.Euler;

import java.util.Date;

import common.util.algorithms.numberTheory.SieveOfEratosthenes;

public class NthPrime {
	
	/**
	 * Problem:
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	   What is the 10 001st prime number?
	 * 
	 * @return
	 */
	public static void main(String[] args) {
		Date start = new Date();
		boolean[] sieve = SieveOfEratosthenes.sieve(104_744);
		int count = 0;
		for(int i=0; i<sieve.length; i++) {
			if(sieve[i]==false) {
				count++;
				if(count==10_001) {
					System.out.println(i);
					Date end = new Date();
					long time = (end.getTime() - start.getTime())/1000;
					System.out.print("Time spent: " + time);
					break;
				}
			}
		}
	}

}
