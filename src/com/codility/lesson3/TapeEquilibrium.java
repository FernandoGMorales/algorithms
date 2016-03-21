package com.codility.lesson3;

public class TapeEquilibrium {
	
	/**
	 * https://codility.com/demo/results/training36WZ3H-MJU/ 100%
	 * 
	 * Took the idea from Khadane's algorithm for finding the largest sum of a sequence
	 * 1) sum all the values.
	 * 2) sum up the ith. element while removing the sum of the ith elements
	 * 3) take the min diff of both sums and store it
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int minDifference = Integer.MAX_VALUE;
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<A.length; i++) {
			sum1+=A[i];			
		}
		for(int i=0; i<A.length-1; i++) { //the original score of 83% was because of this cycle condition i<A.length-1
			sum2+=A[i];
			sum1-=A[i];
			minDifference = Math.min(minDifference, Math.abs(sum2-sum1));						
		}
		return minDifference;
	}
	
	public static void main(String[] args) {
		int minDiff = solution(new int[]{-1000, 1000});
		System.out.print("Minimal difference is: " + minDiff);
	}

}
