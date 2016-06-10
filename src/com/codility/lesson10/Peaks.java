package com.codility.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Peaks {
	
	/**
	 * https://codility.com/demo/results/trainingHEKTHW-65Z/ 100%
	 * 
	 * Facts:
	 * 1 A non-empty zero-indexed array A consisting of N integers is given
	 * 2 A peak is an array element which is larger than its neighbors: 0<P<N−1, A[P−1]<A[P] and A[P]>A[P+1]
	 * 3 We want to divide this array into blocks containing the same number of elements.
	 * 4 every block should contain at least one peak.
	 * 5 Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, 
	 *   but only if they have both neighbors (including one in an adjacent blocks).
	 * 6 The goal is to find the maximum number of blocks into which the array A can be divided.
	 * 7 If A cannot be divided into some number of blocks, the function should return 0.
	 * 8 N is an integer within the range [1..100,000];
	 * 9 each element of array A is an integer within the range [0..1,000,000,000].
	 * 10 expected worst-case time complexity is O(N*log(log(N)));
	 * 11 expected worst-case space complexity is O(N)
	 * 
	 * Solution:
	 *  1- find peaks
	 *  2- check if there are peaks and N is prime or there's just one peak
	 *  3- find divisors of N
	 *  4- for each divisor (group size) check if there is a peak in that range
	 *  
	 * @param A
	 * @return the maximum number of blocks into which the array A can be divided, otherwise zero.
	 */
	static int solution(int[] A) {
		int N = A.length;
		
		// find peaks
		List<Integer> peaks = new ArrayList<>();
		int prev, next;
		for(int i=1; i<N-1; i++) {
			prev = A[i-1];
			next = A[i+1];
			if(A[i]>prev && A[i]>next) {
				peaks.add(i);
				i++;
			}
		}
		if(peaks.isEmpty()) {
			return 0;
		}
		if( (!peaks.isEmpty() && isPrime(N)) || peaks.size()==1 ) {
			return 1;
		}
		
		int result = 1; // currently there's one group
		
		//find divisors/groups of N
		for(int i=3; i<=N; i++) { // size of the group
			if(N%i==0) {
				int k = N/i; // k groups of size i
				int j = i;
				for(int peak : peaks) {
					if(peak<j && peak>=j-i) { // if peak is in range
						j+=i; // check the next group 
						k--; // decrement each group with a peak
					}
					else if(k==0) {
						break;
					}					 
				}
				if(k==0) { // if all groups have been decremented, then all of them have a peak
					result = N/i; // therefore this is the number of groups
					break;
				}
			}
		}				
		return result;
	}
	
	static boolean isPrime(int N) {
		double sqrRootN = Math.sqrt(N);
		for(int i=2; i<=sqrRootN; i++) {
			if(i%N==0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,2,1,1,1, 2,1,1,1,1, 2,1,1,2,1, 1,1,1,1,2}));		
	}

}
