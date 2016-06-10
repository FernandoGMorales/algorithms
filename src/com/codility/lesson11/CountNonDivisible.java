package com.codility.lesson11;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNonDivisible {
	
	/**
	 * 
	 * 
	 * Solution:
	 * 1- count numbers frequencies
	 * 2- find primes
	 * 3- find minimum prime factor for each composite
	 * 4- the prime non-divisors are the rest of the composites/primes - current prime frequency
	 * 5- to find the composite non-divisors, find the divisors and then 
	 * 
	 * @param N
	 * @return
	 */
	public static int[] solution(int[] A) {
		int N = A.length;
		Map<Integer, Integer> counter = new HashMap<>();
		int total = 0;
		
		/* 1-Count # frequencies */
		for (int i = 1; i < N; i++) {
			int frequency = counter.get(A[i]);
			counter.put(A[i], ++frequency);
			total++;
		}
		
		/* 2- Find primes */		
		int max = Collections.max(counter.keySet());
		int[] sieve = sieve(max);
		
		/* 3- Find composite's divisors */
		Map<Integer, Set<Integer>> divisors = new HashMap<>();
		for (int i = 4; i < sieve.length; i++) {
			if(i%sieve[i]==0) {
				Set<Integer> divisorsSet = new HashSet<>();
				int k = i/sieve[i];
				divisorsSet.add(sieve[i]);
				divisorsSet.add(k);
				while(sieve[k]!=0) {
					k /= sieve[k];
					divisorsSet.add(k);
				}
				divisors.put(i, divisorsSet);
			}
		}
		
		/* 4- Find non-divisors for each number  */
		int[] result = new int[N];
		
		return result;
	}

	private static int[] sieve(int N) {
		int[] sieve = new int[N+1];
		double sqrRootOfN = Math.sqrt(N);
		for (int i = 2; i < sqrRootOfN; i++) {
			if(sieve[i]==0) {
				int k = i*i;
				while(k <= N) {
					sieve[k] = i;
					k += i;
				}
			}			
		}
		return sieve;
	}

}
