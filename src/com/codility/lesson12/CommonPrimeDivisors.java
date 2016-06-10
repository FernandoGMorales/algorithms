package com.codility.lesson12;

public class CommonPrimeDivisors {
	
	/**
	 * https://codility.com/demo/results/training4FHY3U-GTT/ 100%
	 * 
	 * Problem find common prime divisors between A[i] and B[i]
	 * 
	 * Solution:
	 * Given that the common divisors of A and B are the gcd(A, B)
	 * 1) Get the gcd(A, B) if gcd==1, continue to the next two numbers
	 * 2) if  
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int solution(int[] A, int[] B) {
		int Z = A.length;
		int count = 0;
		
		for (int i = 0; i < Z; i++) { 
			int a = A[i];
			int b = B[i];
			if(a == b) {	// Equal numbers, they share prime factors.
				count++;
			}
			else {
				int gcd = binaryEuclideanGCD(a, b, 1);	// the common factors of a and b are the gcd(a, b)
				if(gcd == 1) {	// there's no common factors																
					continue;	
				}
				a /= gcd;		// divisors of a not shared with b
				while(a!=1) {	// while there's something else to simplify																	
					int a_gcd = binaryEuclideanGCD(a, gcd, 1);	// the remaining common factors between a and b
					if(a_gcd==1) break;  // there's no more common factors, means a has unique factors and the 
					a /= a_gcd;							// problem requirement is not met
					
				}
				b /= gcd;		// divisors of b not shared with a
				while(b!=1) {	// while there's something else to simplify
					int b_gcd = binaryEuclideanGCD(b, gcd, 1);  // the remaining common factors between b and a
					if(b_gcd==1) break;	 // there's no more common factors, means b has unique factors
					b /= b_gcd;							// problem requirement is not met
				}
				if(a == 1 && b == 1) {	 // both a and b were simplified by their common factors until and both are 
					count++;			 // equal to 1 there's nothing else to simplify.
				}						 // we conclude that a and b has all prime factors in common
			}
		}
		return count;
	}
	
	private int binaryEuclideanGCD(int x, int y, int rem) {
		if(x==y) {
			return x * rem;
		}
		else if(x%2==0 && y%2==0) {
			return binaryEuclideanGCD(x >> 1, y >> 1, 2 * rem);
		}
		else if(x%2==0) {
			return binaryEuclideanGCD(x >> 1, y, rem);
		}
		else if(y%2==0) {
			return binaryEuclideanGCD(x, y >> 1, rem);
		}
		else if(x > y) {
			return binaryEuclideanGCD(x - y, y, rem);
		}
		else {
			return binaryEuclideanGCD(x, y - x, rem);
		}
	}
	
	public static void main(String[] args) {
		CommonPrimeDivisors cpd = new CommonPrimeDivisors();
		int result = cpd.solution(new int[]{15,10,3}, new int[]{75,30,5});
		assert(result==1);
//		result = cpd.solution(new int[]{15_000,100_000_000,1}, new int[]{15_001,100_000_000,1});
//		assert(result==2);		
	}

}
