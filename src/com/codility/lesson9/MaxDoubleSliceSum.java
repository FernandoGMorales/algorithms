package com.codility.lesson9;

public class MaxDoubleSliceSum {
	
	/**
	 * https://codility.com/demo/results/training6DEYJS-VCE/ 100%
	 * 
	 * Problem facts:
	 * 1- A non-empty zero-indexed array A consisting of N integers is given.
	 * 2- A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
	 * 3- The sum of double slice (X, Y, Z) is the total of 
	 *      A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
	 * 4- N is an integer within the range [3..100,000];
	 * 5- each element of array A is an integer within the range [−10,000..10,000].
	 * 6- expected worst-case time complexity is O(N);
	 * 7- expected worst-case space complexity is O(N)
	 * 
	 * Solution: Kadane's algorithm for finding max sub-array sum for the two max sums.
	 * To calculate the max sum array we proceed as usual form left to right (starting at index 1, because X=0), 
	 * but in this case we must store the max so far at each index in a separate array.
	 * To find the second largest sub-array sum we proceed as described above but starting at index N-1 (Z index) 
	 * and going backwards.
	 * 
	 * With both arrays in hand just start iterating as usual, from left to right, at current index do the sum 
	 * left[i-1] + right[i+1] and keep the largest one. 
	 * 
	 * 
	 * Algorithm Invariant
	 * 
	 * @param A
	 * @return the maximal sum of any double slice.
	 */
	public static int solution(int[] A) {
		int N = A.length;		
		
		int[] max_left = new int[N];
		for(int i=1; i<N-1; i++) {
			max_left[i] = Math.max(max_left[i-1] + A[i], 0);
		}
		
		int[] max_right = new int[N];
		for(int i=N-2; i>0; i--) {
			max_right[i] = Math.max(max_right[i+1] + A[i], 0);
		}
		
		int max_slice_sum = Integer.MIN_VALUE;
		for (int i=1; i<N-1; i++) {
			max_slice_sum = Math.max(max_left[i-1] + max_right[i+1], max_slice_sum);
		}
		
		return max_slice_sum;
	}
	
	public static void main(String[] args) {
		int result = solution(new int[] {5, 17, 0, 3 });
		assert (result == 17);
	}

}
