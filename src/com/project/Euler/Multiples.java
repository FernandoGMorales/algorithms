package com.project.Euler;

public class Multiples {
	
	/**
	 * Remember that the sum of the first n natural numbers is: n(n+1)/2
	 * 
	 * Let’s look at the details of our function and take as example n=3.
		We would have to add:
		3+6+9+12+......+999=3*(1+2+3+4+...+333)
		For n=5 we would get:
		5+10+15+...+995=5*(1+2+....+199)
		Now note that 199=995/5 but also 999/5 rounded down to the nearest integer.
	 * 
	 * @param n
	 * @param limit
	 * @return
	 */
	public static int multiplesSumOf(int n, int limit) {
		int target = (limit-1)/n;				
		return n * target*(target+1)/2;
	}
	
	public static void main(String[] args) {
		int total = multiplesSumOf(3,1000) + multiplesSumOf(5,1000) - multiplesSumOf(15,1000);
		System.out.println("Total: " + total);
	}

}
