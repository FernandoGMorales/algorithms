package com.codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
	
	/**
	 *  https://codility.com/demo/results/trainingEMTMSM-NGA/ 100%
	 * 
	 * Problem facts:
	 * 1) A non-empty zero-indexed array A consisting of N integers is given
	 * 2) The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] 
	 * 3) (0 ≤ P < Q < R < N)
	 * 4) N is an integer within the range [3..100,000];
	 * 5) each element of array A is an integer within the range [−1,000..1,000].
	 * 6) expected worst-case time complexity is O(N*log(N));
	 * 7) expected worst-case space complexity is O(1)
	 * 
	 * Solution:
	 * 1) Sort the array
	 * 2) make the product of the two largest negatives times the largst positive
	 * 3) make the product of the three largest positives
	 * 4) return the largest one
	 * 
	 * As an alternative solution we can found the largest negatives an the three largest positives in O(n), but 
	 * for the requeriments O(N*log(N)) is the expected worst case running time.
	 * 
	 * Corner cases:
	 * 
	 * @param A
	 * @return returns the value of the maximal product of any triplet.
	 */
	public static int solution(int[] A) {
		Arrays.sort(A);
		int N = A.length;
		int product1 = A[0]*A[1]*A[N-1];
		int product2 = A[N-3]*A[N-2]*A[N-1];
		return  Math.max(product1, product2);
	}
	
	public static void main(String[] args) {
		int result = solution(new int[]{-3, 1, 2, -2, 5, 6});
		System.out.print("Max product is: " + result);
	}
}
