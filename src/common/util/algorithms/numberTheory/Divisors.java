package common.util.algorithms.numberTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {
	
	/**
	 * Count the number of divisors of N
	 * 
	 * @param n
	 * @return the number of divisors, or 0 if n exceeds the max value for a long 
	 */
	public static int countDivisorsOf(long n) {
		if(n>Long.MAX_VALUE) return 0;
		double sqr_root_n = Math.sqrt(n);
		int count = 0;
		for(int i=2; i<sqr_root_n; i++) {
			if(n%i == 0) { 
				count+=2;
			}
		}
		if(sqr_root_n%1==0) {
			count++;
		}
		return count;
	}
	
	/**
	 * Find the divisors of n.
	 * If the list is empty, then the number is a prime.
	 * 
	 * @param n
	 * @return the list with the divisors of n or null if n exceeds the max value for a long variable.
	 */
	public static List<Long> divisorsOf(long n) {
		if(n>Long.MAX_VALUE) return null;
		double sqr_root_n = Math.sqrt(n);
		List<Long> divisors = new ArrayList<Long>();
		for(int i=2; i<sqr_root_n; i++) { // starts in 2 because 
			if(n%i == 0) { 
				divisors.add((long)i);
				divisors.add(n/i);
			}
		}
		if(sqr_root_n%1==0) {
			divisors.add((long)sqr_root_n);
		}
		Collections.sort(divisors);
		return divisors;
	}
	
	public static void main(String[] args) {
		int n = 100;
		List<Long> divisors = divisorsOf(n);
		System.out.print("Divisors of " + n + ": ");
		for(long d : divisors) {
			System.out.print(d + " ");
		}
	}
	

}
