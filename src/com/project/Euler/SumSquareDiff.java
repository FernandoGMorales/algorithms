package com.project.Euler;

/**
 * Problem: 
 * The sum of the squares of the first ten natural numbers is,
	12 + 22 + ... + 102 = 385
	The square of the sum of the first ten natural numbers is,	
	(1 + 2 + ... + 10)2 = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum 
	is 3025 − 385 = 2640.	
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square 
	of the sum.
	
	Solution:
	1) Find the squares
	2) Sum the squares
	3) Find the sum of the n terms
	4) Find the square of the sum of the n terms
	5) Find the difference between 2 and 4.
	
	See the MIT Notes page 251 for an explanation on how to obtain the below equations
	Also see the MIT Notes page 360
		
	((2n+1)(n+1)n)/6 (sum of squares of a n terms)
	n(n + 1)/2 (sum of the n terms)
	
 * @author fernando
 *
 */
public class SumSquareDiff {
	
	public static int sumSquareDiff(int n) {
		if(n>Math.sqrt(Integer.MAX_VALUE) || n<=0) return 0;
		int sumOfSquares = 0;
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sumOfSquares += i*i;
			sum += i;			
		}
		return sum*sum - sumOfSquares; //5050*5050 - 338350
	}
	
	public static int sumSquareDiff2(int n) {
		if(n>Math.sqrt(Integer.MAX_VALUE) || n<=0) return 0;
		int sumOfSquares = ((2*n+1)*(n+1)*n/6);
		int squareOfSum = (int) Math.pow(n*(n+1)/2, 2);		
		return squareOfSum - sumOfSquares; 
	}	
	
	public static void main(String[] args) {
		int result = sumSquareDiff2(100);
		System.out.print(result);
	}

}
