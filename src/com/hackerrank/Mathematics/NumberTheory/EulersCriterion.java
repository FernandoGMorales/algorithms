package com.hackerrank.Mathematics.NumberTheory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EulersCriterion {
	
	static Logger LOG = Logger.getLogger("EulersCriterion.java");

	// 2**(17 − 1)/2 = 28 ≡ 1 (mod 17)
	/**
	 * https://en.wikipedia.org/wiki/Euler%27s_criterion
	 * 
	 * @param args
	 */
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		int[] cases = new int[testCases*2];
		for(int i=0; i<cases.length-1; i+=2) {
			cases[i] = scanner.nextInt();
			cases[i+1] = scanner.nextInt();			
		}
		for(int i=0; i<cases.length-1; i+=2) {
			int A = cases[i];
			if(A==0) {
				System.out.println("YES");
				continue;
			}
			int M = cases[i+1];
			BigInteger m = BigInteger.valueOf(M);
			BigInteger a = BigInteger.valueOf(A); // see Euler's criterion wiki page 
			BigInteger exponent = BigDecimal.valueOf((M-1)/2).toBigInteger();
			if(m.compareTo(BigInteger.ZERO)==1 && (a.modPow(exponent,m)).compareTo(BigInteger.ONE)==0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}				
		}
    }
	
}
