package com.codility.lesson6;

import java.util.Arrays;

public class Triangle {
	
	/**
	 * https://codility.com/demo/results/training8DNEED-U3H/ 100%
	 * 
	 * Problem facts:
	 * 1) A zero-indexed array A consisting of N integers is given 
	 * 2) A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and
		  	A[P] + A[Q] > A[R],
			A[Q] + A[R] > A[P],
			A[R] + A[P] > A[Q].
	 * 3) N is an integer within the range [0..100,000];
	 * 4) each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	 * 5) expected worst-case time complexity is O(N*log(N));
	 * 6) expected worst-case space complexity is O(N)
	 * 
	 * Solution:
	 * 1) Sort the array in a non-decreasing order.
	 * 2) Given that the array is sorted
	 * 		A[P] + A[Q] > A[R] this condition is not met
			A[Q] + A[R] > A[P] this condition is met
			A[R] + A[P] > A[Q] this condition is met
	 * 
	 * Corner cases: 
	 * 1) A[] = {}
	 * 
	 * @param A
	 * @return 1 if there exists a triangular triplet for this array and returns 0 otherwise.
	 */
	public static int solution(int[] A) {
		if(A.length<3) return 0;
		int result = 0;
		int N = A.length;
		Arrays.sort(A);
		for(int i=0; i<N-2; i++) {			
			int p = A[i];
			int q = A[i+1];
			int r = A[i+2];
			if(r-p<q) { // to avoid overflows the inequality must be expressed in this way
				result = 1;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int result = solution(new int[]{-2,-2,2});
		System.out.print(result==1 ? "There exists one triplet." : "There's no triplets in A");
	}

}
