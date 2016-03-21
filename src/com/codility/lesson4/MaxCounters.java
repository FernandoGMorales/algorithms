package com.codility.lesson4;

public class MaxCounters {
	
	/**
	 * Facts:
	 * 1) You are given N counters, initially set to 0
	 * 2) you have two possible operations on them: 
	 * 		-increase(X) − counter X is increased by 1,
	 * 		-max counter − all counters are set to the maximum value of any counter.
	 * 3) A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
	 * 		-if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	 * 		-if A[K] = N + 1 then operation K is max counter.
	 * 4) N and M are integers within the range [1..100,000];
	 * 5) each element of array A is an integer within the range [1..N + 1].
	 * 
	 * Invariant: 
	 * 
	 * @param N
	 * @param A
	 * @return returns a sequence of integers representing the values of the counters.
	 * 
	 * 
	 * First attempt: https://codility.com/demo/results/trainingWFJ8A8-BVV/ 77% 38 minutes
	 * 
	 */
	public static int[] slowSolution(int N, int[] A) {		
		int[] counter = new int[N];
		int max = 0;
		for(int i : A) {
			if(i<=N) {
				counter[i-1]++;
				max = Math.max(counter[i-1], max);
			}
			else {
				for(int j=0; j<counter.length; j++) {
					counter[j] = max;
				}
			}			
		}
		return counter; 
    }
	
	/**
	 * https://codility.com/demo/results/training9Z63JS-8YV/ 100%
	 * 
	 * Second attempt, the trick is to update all the count values that are less than the lastUpdate (absoluteMax) 
	 * to the max value.
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	public static int[] solution(int N, int[] A) {		
		int[] counter = new int[N];
		int currentMax = 0;
		int absoluteMax = 0;
		for(int i : A) {
			if(i>N) {
				absoluteMax = currentMax;	// A[i]==N+1 -> update operation															
			}
			else {
				counter[i-1] = Math.max(counter[i-1], absoluteMax); // update current counter to max if applicable
				counter[i-1]++;
				currentMax = Math.max(counter[i-1], currentMax); // keep updated the max value of the counter so far
			}
		}
		for(int i=0; i<counter.length; i++) {
			counter[i] = Math.max(counter[i], absoluteMax);
		}
		return counter; 
    }
	
	public static void main(String[] args) {
		int[] counter = solution(10, new int[]{1,3,10,10,11});
		for(int i : counter) {
			System.out.print(" " + i);
		}
	}

}
