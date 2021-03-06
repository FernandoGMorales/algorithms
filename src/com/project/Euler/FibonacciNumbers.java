package com.project.Euler;

public class FibonacciNumbers {
	
	public static final int LIMIT = 4_000_000; 
	
	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
	 * By starting with 1 and 2, the first 10 terms will be:

		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

	   By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
	   find the sum of the even-valued terms.
	   
	 * @param n
	 * @return
	 */
	public static int fibonacciNumber(int n) {
		int[] fibonacci_sequence = new int[n+1];
		fibonacci_sequence[0] = 0;
		fibonacci_sequence[1] = 1;
		int sum = 0;
		for(int i=2; i<=n; i++) {			
			fibonacci_sequence[i] = fibonacci_sequence[i-1] + fibonacci_sequence[i-2];
			if(fibonacci_sequence[i]>LIMIT) {
				break;
			}
			if(fibonacci_sequence[i]%2==0) {
				sum+=fibonacci_sequence[i];
			}			
		}		
		return sum;
	}
	
	public static void main(String[] args) {
		int fibo = fibonacciNumber(100000);
		System.out.print(fibo);
	}

}
