package com.project.Euler;

public class LargestPalindromeProduct {
	
	public static int largestPalindromeProductOfTwoNDigitNumber(int n) {
		if(n>9) return 0; 
		int result = 0;
		int N = (int)Math.pow(10, n);
		int lower_bound = (int) Math.pow(10, n-1);
		for(int i=N-1; i>lower_bound-1; i--) {
			for(int j=i; j>lower_bound-1; j--) {
				int x = i*j;				
				StringBuilder str = new StringBuilder(String.valueOf(x));
				if(str.toString().equals(str.reverse().toString())) {
					result = Math.max(result, x);										
				}
			}			
		}
		return result;
	}
	
	public static void main(String[] args) {
		int result = largestPalindromeProductOfTwoNDigitNumber(4);
		System.out.println(result);
	}
	
}
