package com.codility.lesson5;

public class MinAvgTwoSlice {
	
	/**
	 * https://codility.com/demo/results/trainingXQW2KE-79E/ 100%
	 * 
	 * Problem facts:
	 * 1) A non-empty zero-indexed array A consisting of N integers is given.
	 * 2) A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A 
	 *    (notice that the slice contains at least two elements).
	 * 3) the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1)
	 * 4) If there is more than one slice with a minimal average, you should return the smallest starting 
	 *    position of such a slice.
	 * 5) N is an integer within the range [2..100,000];
	 * 6) each element of array A is an integer within the range [−10,000..10,000].
	 * 7) expected worst-case time complexity is O(N);
	 * 8) expected worst-case space complexity is O(N)
	 * 
	 * Solution facts:
	 * 1) A slice of size > 3 can be decomposed in sub-slices
	 * 2) The average of a slice of size n is then decomposed in: k(x/2) + j(y/3), this means that there can be 
	 * k terms of the form x/2 and also there can be j terms of the form y/3; x = (x1+x2), and
	 * y = (y1+y2+y3).
	 * 3) Given the following assumption, we have two possible choices for finding out the index of the min avg
	 * (for simplicity lets make k(x/2) = K and j(y/3) = J)
	 *  a) K<=J, the index is in x1
	 *  b) K>J, the index is in y1
	 * 	    
	 * 
	 * Proof by contradiction: to proof the above statement, lets suppose that there exist a slice (>3) 
	 * with average less than the average of its sub-slices.
	 * Now suppose that this slice can be divided in two sub-slices: sub-slice-1 and sub-slice-2 with averages 
	 * ss1 and ss2 respectively.
	 * Also suppose ss1>ss2. This means that ss2 must be less than the original slice avg, but this contradicts 
	 * our original assumption, and therefore we have proved that there must be at least one sub-slice with avg
	 * less than the original slice. 
	 * 
	 * @param A
	 * @return the starting position of a slice whose average is minimal
	 */
	public static int solution(int[] A) {
		int N = A.length;
		if(N==2) return 0;
		int minAvgStartIdx = 0;		
		double min_avg = (A[0]+A[1])/2.0; // pay attention to the decimal numbers		
		/*
		 * The trick is to calculate each sub-slice of two and three slots and to keep track of the minimum found
		 */
		for(int i=2; i<N; i++) {
			double avg1 = (A[i-1]+A[i])/2.0; 
			double avg2 = (A[i-2]+A[i-1]+A[i])/3.0; // pay attention to the decimal numbers			
			if(avg2<avg1 && avg2<min_avg) {
				min_avg = avg2;
				minAvgStartIdx = i-2;
			}
			else if(avg1<min_avg) {
				min_avg = avg1;
				minAvgStartIdx = i-1;
			}
		}		
		return minAvgStartIdx;
	}
	
	public static void main(String[] args) {
		int index = solution(new int[]{-3, -5, -8, -4, -10});
		System.out.print("Min avg slice index at: " + index);
	}

}
