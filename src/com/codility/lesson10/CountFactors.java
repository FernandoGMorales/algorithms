package com.codility.lesson10;

public class CountFactors {
	
	/**
	 * https://codility.com/demo/results/training4M2E4Y-NXR/ 100%
	 * 
	 * Facts:
	 * 1- A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
	 * 2- For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
	 * 3- given a positive integer N, returns the number of its factors.
	 * 4- N is an integer within the range [1..2,147,483,647].
	 * 5- expected worst-case time complexity is O(sqrt(N));
	 * 6- expected worst-case space complexity is O(1).
	 * 
	 *  Solution:
	 *  
	 * 
	 * @param N
	 * @return given a positive integer N, returns the number of its factors.
	 */
	static int solution(int N) {
		double sqrRootN = Math.sqrt(N);
		int count = 0;
		for (int i = 1; i < sqrRootN; i++) {
			if (N % i == 0) {
				count += 2; // count two factors: i and N/i
			}
		}
		count += sqrRootN % 1 == 0 ? 1 : 0; // if square root of N is integer then add 1 factor
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(24));
	}

}
