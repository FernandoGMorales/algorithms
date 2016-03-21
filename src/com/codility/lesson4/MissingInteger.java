package com.codility.lesson4;

public class MissingInteger {
	
	/**
	 *  https://codility.com/demo/results/trainingWH2WXD-FK8/ 100%
	 * 
	 * By the Pigeonhole principle that states, if there are more pigeons than holes, then at least one hole hold more
	 * than one pigeon.
	 * 
	 * Facts:
	 * a) There are N integers
	 * b) I need to find the minimum integer > 0
	 * c) If there are N integers and there's one minimum integer missing, then that element is in the range N+1
	 * 
	 * Invariant: the missing element is in the range 1 to N+1
	 * The first loop counts the N elements
	 * The second loop find the minimum element by maintaining the invariant described above
	 * 1) Initialization: prior to the first iteration the numberCounter array starts in index 1 
	 * 2) Maintenance: after the ith iteration the missing element is in the range N+1-ith
	 * 3) Finishing: when the loop exits the element ith + 1 element has no ocurrences in the original array
	 * and therefore it's the minimum missing element. Proving that the element was in the range 1 - N+1.
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		int[] numberCounter = new int[A.length+2];
		int missingElement = 0;
		for(int i : A) {
			if(i>=1 && i<=A.length) {
				numberCounter[i]++;
			}
		}
		for(int i=1; i<numberCounter.length; i++) {
			if(numberCounter[i]==0) {
				missingElement = i;
				break;
			}
		}
		return missingElement;
	}
	
	public static void main(String[] args) {
		MissingInteger m = new MissingInteger();
		int min = m.solution(new int[]{1,1,1,1,-10000000});
		System.out.println("Minimum element is: " + min);
	}

}
