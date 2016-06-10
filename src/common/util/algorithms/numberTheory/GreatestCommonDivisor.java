package common.util.algorithms.numberTheory;

import java.math.BigInteger;

import static java.math.BigInteger.*; 

public class GreatestCommonDivisor {
	
	private final static BigInteger TWO = BigInteger.valueOf(2);	
	
	/**
	 * GCD by dividing
	 * Applies recursively the following property GCD: gcd(a,b) = gcd(b,rem(a,b))
	 * 
	 * Time complexity: O(log(a + b))
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int euclidGCD(int x, int y) throws Exception { 
		if(x==0 || y==0) {
			throw new Exception("Cannot calculate gcd of " + x + " and " + y);
		}
		else {
			return calculateGCD(x, y%x);
		}
		
	}
	
	private static int calculateGCD(int x, int rem) {
		if(rem==0) { // base case
			return x;
		}
		else {
			return calculateGCD(rem, x%rem);
		}
	}
	
	/**
	 * This algorithm finds the gcd using only subtraction, binary representation, shifting and parity testing.
	 * The following function calculate gcd(a, b, res) = gcd(a, b, 1) · res. So to calculate gcd(a, b) it suffices
	 * to call gcd(a, b, 1) = gcd(a, b).
	 *
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 */
	public static BigInteger binaryEuclideanAlgorithm(BigInteger a, BigInteger b, BigInteger res) {
		if(a.compareTo(b)==0) {
			return a.multiply(res);
		}
		else if( (a.mod(TWO).compareTo(ZERO)==0) && (b.mod(TWO).compareTo(ZERO)==0) ) {
			return binaryEuclideanAlgorithm(a.shiftRight(1), b.shiftRight(1), TWO.multiply(res));
		}
		else if(a.mod(TWO).compareTo(ZERO)==0) {
			return binaryEuclideanAlgorithm(a.shiftRight(1), b, res);
		}
		else if(b.mod(TWO).compareTo(ZERO)==0) {
			return binaryEuclideanAlgorithm(a, b.shiftRight(1), res);
		}
		else if(a.compareTo(b)==1) {
			return binaryEuclideanAlgorithm(a.subtract(b), b, res);
		}
		else {
			return binaryEuclideanAlgorithm(a, b.subtract(a), res);
		}		
	}
	
	public static void main(String[] args) throws Exception {
//		System.out.println(euclidGCD(100, 4));
		BigInteger a = new BigInteger("15");
		BigInteger b = new BigInteger("75");
		BigInteger result = binaryEuclideanAlgorithm(a, b, ONE);
		System.out.println(result);
	}

}
