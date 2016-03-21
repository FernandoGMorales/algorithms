package com.codility.lesson5;

public class CountDiv {
	
	/**
	 * https://codility.com/demo/results/trainingG4JZBS-F98/ 100%
	 * 
	 * Problem facts:
	 * 1) { i : A ≤ i ≤ B, i mod K = 0 }
	 * 2) A and B are integers within the range [0..2,000,000,000];
	 * 3) K is an integer within the range [1..2,000,000,000];
	 * 4) A ≤ B.
	 * 
	 * Solution facts
	 * 1) x mod k=0, for all x<=A are obtained by A/K
	 * 2) y mod k=0, for all y<=B are obtained by B/K
	 * 3) the numbers we are looking for are in: B/K - (A-1)/K  (A-1 is because A<=i)
	 * 4) if A==0 then the numbers are found in B/K + 1 (plus one, because 0 mod K == 0)     
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public static int solution(int A, int B, int K) {
		return (A!=0) ? B/K-(A-1)/K : B/K + 1;
    }
	
	public static void main(String[] args) {
		int divs = solution(0, 0, 11);
		System.out.println("# of divs: " + divs);
	}

}
