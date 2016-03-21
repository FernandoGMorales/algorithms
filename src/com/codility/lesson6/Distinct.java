package com.codility.lesson6;

import java.util.Arrays;

public class Distinct {
	
	/**
	 * https://codility.com/demo/results/trainingGYB2Y5-NVN/ 100%
	 * 
	 * Problem facts:
	 * 1) given a zero-indexed array A consisting of N integers
	 * 2) N is an integer within the range [0..100,000];
	 * 3) each element of array A is an integer within the range [−1,000,000..1,000,000].
	 * 4) expected worst-case time complexity is O(N*log(N));
	 * 5) expected worst-case space complexity is O(N)
	 * 
	 * Solution:
	 * 1) Sort the array in a non decreasing order O(nlgn) 
	 * 2) Iterate the array O(n)
	 * 3) Count each number greater than the previous one
	 * 4) Total running time for the worst case will be n + nlgn = 2n lgn = O(nlgn)
	 * 
	 * @param A
	 * @return the number of distinct values in array A
	 */
	public static int solution(int[] A) {
		if(A.length==0) return 0; // pay attention to problem fact 2 (the array can be empty)
		Arrays.sort(A);
		int distinct = 1; // the array has at least one element
		for(int i=1; i<A.length; i++) {
			if(A[i-1]<A[i]) {
				distinct++;
			}
		}
		return distinct;
	}
	
	public static void main(String[] args) {
		int distincts = solution(new int[]{});
		System.out.print("Number distincts: " + distincts);
	}

}
