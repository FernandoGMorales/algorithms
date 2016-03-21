package com.codility.lesson5;

public class PassingCars {
	
	/**
	 * https://codility.com/demo/results/trainingNPCPTB-6MA/ 100%
	 * 
	 * Problem facts:
	 * 1) A non-empty zero-indexed array A consisting of N integers is given.
	 * 2) Array A contains only 0s and/or 1s
	 * 3) 0 represents a car traveling east
	 * 4) 1 represents a car traveling west
	 * 5) The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, 
	 *    is passing when P is traveling to the east and Q is traveling to the west.
	 * 6) The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
	 * 7) N is an integer within the range [1..100,000];
	 * 8) each element of array A is an integer that can have one of the following values: 0, 1.
	 *
	 * The trick is to count 1's backwards and sum partial totals for each 0.
	 * Pay attention to the constraints, ie: 
	 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
	 * 
	 * 
	 * @param A
	 * @return
	 */
	
	/*
	 * It is a good practice to put constraints as a constants if possible
	 */
	public final static int PAIRS_LIMIT = 1000000000;
	public final static int OUT_OF_BOUNDS = -1;
	
	public static int solution(int[] A) {
		int pairs = 0;
		int ones = 0;		
		for(int i=A.length-1; i>=0; i--) {
			if(A[i]==1) ones++;
			else {
				if(pairs>=PAIRS_LIMIT) return OUT_OF_BOUNDS;
				pairs+=ones;
			}
		}
		return pairs;        
    }
	
	public static void main(String[] args) {
		int pairs = solution(new int[]{1,1,1,1,1,1});
		System.out.print("Pairs found: " + pairs);
	}

}
