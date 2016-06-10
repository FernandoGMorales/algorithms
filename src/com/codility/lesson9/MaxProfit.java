package com.codility.lesson9;

public class MaxProfit {
	
	/**
	 * https://codility.com/demo/results/trainingQZJJ6T-U9J/ 100%
	 * 
	 * Problem facts:
	 * 1- A zero-indexed array A consisting of N integers is given.
	 * 2- Transaction profit is equal to A[Q] − A[P] given that 0<=P<=Q<N 
	 *  (the transaction can be made in the same day, i.e: P=Q)
	 * 3- N is an integer within the range [0..400,000];
	 * 4- each element of array A is an integer within the range [0..200,000]
	 * 5- expected worst-case time complexity is O(N);
	 * 6- expected worst-case space complexity is O(1)
	   
	   Solution steps: 
	   1) Keep track of the minimum value found so far while iterating.
	   2) Calculate the profit between current value and the minimum value
	   3) Keep track of the maximum profit found so far.
	   
	   Loop invariant: max_profit < max(A)  
	   
	 * @param A
	 * @return
	 */
	public static int solution(int A[]) {
		if(A.length<2) {
			return 0;
		}
		int max_profit = Integer.MIN_VALUE;
		int current_profit = 0;
		int current_min = Integer.MAX_VALUE;		 							
		for(int i=0; i<A.length; i++) {
			current_min = Math.min(A[i], current_min);				// step 1
			current_profit = A[i]-current_min;					   // step 2 
			max_profit = Math.max(current_profit, max_profit); 	  // step 3			
		}
		return max_profit;
	}
	
	public static void main(String[] args) {
		assert(solution(new int[]{9,8,7,6,5,4,3,2,1})==0);
		assert(solution(new int[]{1,2,3,4,5,6,7,8,9})==8);
		assert(solution(new int[]{2,3,4,5,6,7,8,1,9})==8);
		assert(solution(new int[]{2,3,4,5,6,7,8,9,1})==7);
		assert(solution(new int[]{0})==0);
		assert(solution(new int[]{1})==0);
		assert(solution(new int[]{})==0);
		assert(solution(new int[]{1,1})==0);
		assert(solution(new int[]{1,2})==1);
		assert(solution(new int[]{-1,2})==3);
		assert(solution(new int[]{0,0,0,0,0,0,0,0,0,0,0,0})==0);
	}

}
