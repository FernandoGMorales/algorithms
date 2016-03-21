package com.project.Euler;

import java.math.BigInteger;

import common.util.algorithms.numberTheory.Factorial;

public class LatticePaths {
	
	public static void main(String[] args) {
		int n = 20;
		BigInteger factorial_2n = Factorial.factorial(2*n);
		BigInteger factorial_n = Factorial.factorial(n);
		BigInteger factorial_2n_n = Factorial.factorial((2*n)-n);
		BigInteger denominator = factorial_n.multiply(factorial_2n_n);
		BigInteger paths = factorial_2n.divide(denominator);
		System.out.print(paths);
	}

}
