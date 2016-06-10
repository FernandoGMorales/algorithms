package com.codility.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FibFrog {
	
	/**
	 * Problem:
	 * 1) A small frog wants to get to the other side of a river. The frog is initially located at one bank 
	 * of the river (position −1) and wants to get to the other bank (position N).
	 * 2) The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. 
	 * 3) The leaves on the river are represented in a zero-indexed array A consisting of N integers.
	 * 4) Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river.
	 * 5) Array A contains only 0s and/or 1s (0 represents a position without a leaf)
	 * 6) The goal is to count the minimum number of jumps in which the frog can get to the other side of the river
	 * 7) N is an integer within the range [0..100,000];
	 * 8) each element of array A is an integer that can have one of the following values: 0, 1
	 * 9) expected worst-case time complexity is O(N*log(N))
	 * 
	 * Solution:
	 * 1) Find the fibonacci numbers up to N
	 * 2) Iterate backwards the leaves array looking for the largest fibonacci numbers to jump to
	 * 3) After the first jump
	 * 
	 * @param A
	 * @return the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot 
	 * reach the other side of the river, the function should return −1.
	 */
	public int solution(int[] A) {		
		int N = A.length;
		
		List<Integer> fiboList = fibonacciSequence(N);
		
		if(fiboList.contains(N + 1)) {
			return 1;
		}
		
		Set<Integer> jumpSet = new HashSet<>();
		int k = A.length;
		do {
			int jumps = 0;
			for (; k > 0; k--) {
				if(A[k-1] == 1) {
					jumps = test(Arrays.copyOfRange(A, 0, k), fiboList);
					break;
				}
			}			
			if(jumps > 0) {
				jumpSet.add(jumps);
			}
			k--;
		} while(k >= 0);
		
		return !jumpSet.isEmpty() ? Collections.min(jumpSet) : -1;
	}	

	/**
	 * 
	 * @param A
	 * @param fiboList
	 */
	private int test(int[] A, List<Integer> fiboList) {
		for (int i = 0; i < A.length; i++) {
			if(A[i] == 1 && fiboList.contains(i + 1)) {
				int jumps = test(Arrays.copyOfRange(A, i + 1, A.length), fiboList);
				return (jumps > 0) ? ++jumps : jumps;
			}
		}
		if(fiboList.contains(A.length+1)) {
			return 1;
		}
		return -1;
	}

	/**
	 * Returns the fibonacci sequence of numbers less than N.
	 * 
	 * @param N
	 * @return
	 */
	private List<Integer> fibonacciSequence(int N) {
		List<Integer> fiboList  = new ArrayList<>();
		int prev2 = 0;
		int prev1 = 1;
		fiboList.add(prev2);
		fiboList.add(prev1);
		for (int i = 2; i <= N; i++) {
			int fibonacciNumber = prev1 + prev2;						
			if(fibonacciNumber == N+1) {
				fiboList.add(fibonacciNumber);
				break;							
			}
			else if(fibonacciNumber > N) {
				break;							
			}
			else {
				fiboList.add(fibonacciNumber);
				prev2 = prev1;
				prev1 = fibonacciNumber;
			}
		}		
		return fiboList;
	}
	
	public static void main(String[] args) {
		FibFrog f = new FibFrog();
//		List<Integer> fibo = f.fibonacciSequence(987);
//		System.out.print(fibo); // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987]
		int jumps = 0;
//		jumps = f.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}); // N = 14
//		assert(jumps==2);
//		jumps = f.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}); // N = 12
//		assert(jumps==1);
//		jumps = f.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0});
//		assert(jumps==1);
//		jumps = f.solution(new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0});
//		assert(jumps==1);
//		jumps = f.solution(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}); // N = 17
//		assert(jumps==2);
//		jumps = f.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}); // N = 17
//		assert(jumps==-1);
		jumps = f.solution(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0}); // N = 21
		assert(jumps==5);
		jumps = f.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}); // N = 21
		assert(jumps==2);
		jumps = f.solution(new int[]{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1}); // N = 21
		assert(jumps==2);
		
	}

}
