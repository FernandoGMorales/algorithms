package com.codility.lesson6;

import java.util.Arrays;

public class NumberOfDiscIntersections {
	
	/**
	 * 
	 * https://codility.com/demo/results/trainingC3G8K6-2EU/ 100%
	 * Explanation:
	 * http://rafal.io/posts/codility-intersecting-discs.html
	 * 
	 * Problem facts:
	 * 1- We draw N discs on a plane. The discs are numbered from 0 to N − 1
	 * 2- A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given.
	 * 3- The J-th disc is drawn with its center at (J, 0) and radius A[J]
	 * 4- We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at 
	  	  least one common point
	 * 5- The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
	 * 6- N is an integer within the range [0..100,000];
	 * 7- each element of array A is an integer within the range [0..2,147,483,647].
	 * 8- expected worst-case time complexity is O(N*log(N))
	 * 9- expected worst-case space complexity is O(N)
	 * 
	 * @param A
	 * @return
	 */
	
	static final int INTERSECTION_PAIRS_OVERFLOW = 10000000;
	
	public static int solutin(int[] A) {
		int number_of_discs = A.length;
		long[] start_range = new long[number_of_discs];
		long[] end_range = new long[number_of_discs];
		
		for(int i=0; i<number_of_discs; i++) {
			 start_range[i] = (long)A[i]+i;
			 end_range[i] = (long)-(A[i]-i);
		}
		
		Arrays.sort(start_range);
		Arrays.sort(end_range);
		
		long intersected_discs = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			int pos = Arrays.binarySearch(end_range, start_range[i]);
			if (pos >= 0) {
				while (pos < A.length && end_range[pos] == start_range[i]) {
					pos++;
				}
				intersected_discs += pos;
			} else { // element not there
				int insertionPoint = -(pos + 1);
				intersected_discs += insertionPoint;
			}			
		}
		
		long sub = (long)number_of_discs*((long)number_of_discs+1)/2;
		intersected_discs = intersected_discs - sub;
		
		if(intersected_discs>INTERSECTION_PAIRS_OVERFLOW) return -1;
		
		return (int)intersected_discs;
	}
	
	public static void main(String[] args) {
		
	}

}
