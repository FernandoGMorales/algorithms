package com.codility.lesson9;

public class MaxSliceSum {
	
	/**
	 * https://codility.com/demo/results/trainingYV2ABW-8XU/ 100%
	 * 
	 * Problem facts:
	 * 1-A non-empty zero-indexed array A consisting of N integers is given
	 * 2-A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A
	 * 3-The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
	 * 4-N is an integer within the range [1..1,000,000];
	 * 5-each element of array A is an integer within the range [−1,000,000..1,000,000];
	 * 6-the result will be an integer within the range [−2,147,483,648..2,147,483,647].
	 * 7-expected worst-case time complexity is O(N)
	 * 8-expected worst-case space complexity is O(N)
	 * 
	 * Solution: Kadane's algorithm for finding max sub-array sum.
	 * 
	 * Invariant: max_slice >= max(A) 
	 * 
	 * @param A
	 * @return the maximum sum of any slice of A.
	 */
	public static int solution(int[] A) {
		int max_slice = Integer.MIN_VALUE;
		int current_max = 0;
		for (int i = 0; i < A.length; i++) {
			current_max = Math.max(A[i], current_max+A[i]);
			max_slice = Math.max(current_max, max_slice);
		}
		return max_slice;
	}
	
	public static void main(String[] args) {
		assert(solution(new int[]{3,2,-6,4,0})==5);
		assert(solution(new int[]{1})==1);
		assert(solution(new int[]{0})==0);
		assert(solution(new int[]{-1,1})==1);
		assert(solution(new int[]{-1,-1})==-1);
		assert(solution(new int[]{0,0})==0);
		assert(solution(new int[]{0,0,0,0,0,0,0,1})==1);
		assert(solution(new int[]{1,0,0,0,0,0,0,0})==1);
		assert(solution(new int[]{1,0,0,0,0,0,0,-1})==1);		
	}

}
