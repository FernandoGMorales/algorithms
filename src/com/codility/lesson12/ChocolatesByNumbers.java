package com.codility.lesson12;

public class ChocolatesByNumbers {
	
	/**
	 * https://codility.com/demo/results/trainingJGTFDJ-RJE/ 100%
	 * 
	 * 
	 * Solution: Using the Euclid gcd algorithm by division, the number of chocolates to eat will be equal to 
	 * N divided by the GCD (aka greatest common divisor) between M and N.
	 * 
	 * Solution steps:
	 * 1- Find gcd by using some of the euclidean algorithms, in this case based on the size of the input numbers 
	 * and given the time complexity expected, the euclidean algorithm by division is a perfect choice.
	 * 2- The number of max # of chocolates that can be eaten is N / gcd(N, M)
	 * 
	 * If N != M and one of them or both are prime, then the gcd(N, M) == 1, so the result is N, so the below
	 * solution could be improve for very large inputs.
	 * 
	 * @param N
	 * @param M
	 * @return
	 */
	public int solution(int N, int M) {
		int gcd = 0;
		if(N == M) {
			gcd = N;
		}
		else {
			gcd = euclidGCD(N, M%N);
		}
		return N/gcd;
	}
	
	/**
	 * Euclid algorithm by dvision is based on the gcd property gcd(a,b) = gcd(b,rem(a,b)), the rem(a,b) is
	 * equal to (a mod b) or, as in our problem, (M mod N);
	 * 
	 * @param N
	 * @param rem
	 * @return
	 */
	private int euclidGCD(int N, int rem) {
		if(rem == 0) {
			return N;
		}
		else {
			return euclidGCD(rem, N%rem);
		}
	}
	
	public static void main(String[] args) {
		ChocolatesByNumbers c = new ChocolatesByNumbers();
		assert(c.solution(10, 1) == 10);
		assert(c.solution(10, 2) == 5);
		assert(c.solution(10, 3) == 10);
		assert(c.solution(10, 4) == 5);
		assert(c.solution(10, 5) == 2);
		assert(c.solution(10, 6) == 5);
		assert(c.solution(10, 7) == 10);
		assert(c.solution(10, 8) == 5);
		assert(c.solution(10, 9) == 10);
		assert(c.solution(10, 10) == 1);
		System.out.println(c.solution(100, 2));
	}

}
