package com.codility.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Flags {
	
	/**
	 * see solution doc
	 * 
	 * Problem facts:
	 * 
	 * Solution:
	 * Given that max # of flags = max # of intervals of N, then max # of flags is the square root of N 
	 * 1- find peaks
	 * 2- check if there's a match for a given peak position/interval of size k 
	 * 
	 * @param A
	 * @return
	 */
	static int solution(int[] A) {
		int N = A.length;
		if(N<3) {
			return 0;
		}
		// 1- find peaks
		List<Integer> peaks = new ArrayList<>();
		int peaks_count = 0;
		for (int i=1; i<N-1; i++) {			
			if(A[i] > Math.max(A[i - 1], A[i + 1])) {
				peaks.add(i);
				peaks_count++;
				i++; // the next element cannot be a peak
			}
		}
		
		double sqr_root = Math.sqrt(N);
		// max # of flags given max # of intervals
		int max_flags = (int) Math.min(sqr_root, peaks_count);
		
		// 2-check if there's a peak in each interval		
		for (int i=max_flags; i >= 0; i--) {
			int k = 0;
			for (int peak : peaks) {
				if(peak>k && peak<k+i) {
					k+=i;
				}
			}
			if(k==N) {
				break;
			}
		}
		
		return max_flags;
	}

	public static void main(String[] args) {
//		System.out.println(solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
		System.out.println(solution(new int[]{1, 4, 5, 3, 6, 1}));
	}
 
}
