package com.codility.lesson11;

import java.util.Arrays;

public class CountSemiprimes {
	
	/**
	 * https://codility.com/demo/results/training2A6CBT-QTC/ 100 %
	 * 
	 * Problem facts:
	 * 1- A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. 
	 *    The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
	 * 2- You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. 
	 *    These arrays represent queries about the number of semiprimes within specified ranges.
	 * 3- Query K requires you to find the number of semiprimes within the range 
	 * 	  (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
	 * 4- N is an integer within the range [1..50,000];
	 * 5- M is an integer within the range [1..30,000];
	 * 6- each element of arrays P, Q is an integer within the range [1..N];
	 * 7- P[i] ≤ Q[i].
	 * 8- expected worst-case time complexity is O(N*log(log(N))+M);
	 * 9- expected worst-case space complexity is O(N+M)
	 * 
	 * 
	 * Solution:
	 * 1- Find primes up to N 
	 * 2- Count semi-primes up to N and accumulate them for each i, given i<N.
	 * 3- Iterate P and Q and find the semi-primes by doing the difference between the upper range and the 
	 * lower range-1 (because the range is inclusive).  
	 * 
	 * @param N
	 * @param P
	 * @param Q
	 * @return an array consisting of M elements specifying the consecutive answers to all the queries.
	 */
	public static int[] solution(int N, int[] P, int[] Q) {
		/* 1- Find primes up to N */
		int[] sieve = sieve(N);
		/* 2- Count semi-primes up to N and accumulate them for each i, given i<N. */
		int[] semiprimes = new int[N];
		semiprimes = semiPrimes(sieve);
		/* 3- Iterate P and Q and find the semi-primes by doing the difference between the upper range and the 
	  		  lower range-1 (because the range is inclusive). */
		int M = P.length;
		int[] result = new int[M];
		for(int i=0; i<M; i++) {				// the first known semi-prime is 4
			int from = P[i];
			int to = Q[i];
			result[i] = semiprimes[to] - semiprimes[from-1]; // the lower limit is in the range so we need to look
															// for the accumulated immediately before it 
		}		
		return result;
	}
	
	/**
	 * Count and accumulate semi-primes up to sieve.lenght
	 * @param sieve
	 * @return
	 */
	private static int[] semiPrimes(int[] sieve) {
		int semis = 0;
		int[] semiprimes = new int[sieve.length];
		for(int i=4; i<sieve.length; i++) {				// the first known semi-prime is 4
			if(sieve[i]!=0 && sieve[i/sieve[i]]==0) {	// 1- Verify if current number is composite and if 
														// the other factor (i/sieve[i]) is also prime.				  
				semis++;								// 2- Its prime, so we count it. 
				semiprimes[i] = semis;					// 3- And accumulate the total up to i.
			}
			else {
				semiprimes[i] = semis;					// Accumulate the total up to i.
			}
		}
		return semiprimes;
	}

	/*
	 * A variation of the Sieve of Eratosthenes, for each composite number it will keep
	 * track of its smallest prime factor.
	 * Time complexity: O(n log log n)
	 * true = prime, false = composite
	 *  
	 */
	private static int[] sieve(int N) {		
		int[] sieve = new int[N+1];
		double sqrtOfN = Math.sqrt(N);				
		for(int i=2; i<=sqrtOfN; i++) {
			if(sieve[i]==0) {
				int k = i*i;
				while(k<=N) {
					sieve[k] = i;
					k += i;
				}
			}
		}
		return sieve;
	}

	public static void main(String[] args) {
		
		int[] result = solution(26, new int[]{1,4,16}, new int[]{26,10,20});
		assert(Arrays.equals(result, new int[]{10,4,0}));
		
		result = solution(26, new int[]{4,4,16}, new int[]{26,10,20});
		assert(Arrays.equals(result, new int[]{10,4,0}));
		
		result = solution(26, new int[]{5,4,16}, new int[]{26,10,20});
		assert(Arrays.equals(result, new int[]{9,4,0}));
		
		result = solution(26, new int[]{1,1,1}, new int[]{1,1,1});
		assert(Arrays.equals(result, new int[]{0,0,0}));
		
		result = solution(1, new int[]{1,1,1}, new int[]{1,1,1});
		assert(Arrays.equals(result, new int[]{0,0,0}));
		
		result = solution(1, new int[]{1}, new int[]{1});
		assert(Arrays.equals(result, new int[]{0}));
		
		result = solution(50_000, new int[]{30_000}, new int[]{30_000});
		assert(Arrays.equals(result, new int[]{0}));
		
	}
	
}
