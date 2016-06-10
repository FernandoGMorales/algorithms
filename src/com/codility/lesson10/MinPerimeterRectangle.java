package com.codility.lesson10;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinPerimeterRectangle {
	
	/**
	 * https://codility.com/demo/results/trainingDENVDK-H7P/ 100%	 * 
	 * 
	 * There's a pattern in the provided example:
	 *  (1, 30), with a perimeter of 62,
		(2, 15), with a perimeter of 34,
		(3, 10), with a perimeter of 26,
		(5, 6), with a perimeter of 22.
		
	 *	After trying with other examples, it seems that the rectangle with the smallest perimeter 
	 *	for a given area will always be a square. 
	 * This means that, given an area, the optimal rectangle will have a length and a width that are 
	 * the same size. In other words, the length (or width ) will be the square root of the area.
	 * 
	 * Proof: by induction
	 * a) X and Y are the sides of the rectangle
	 * b) perimeter of the square = 4*X (X==Y)
	 * c) perimeter of the rectangle = 2*(X+Y) and (X<Y)
	 * 
	 * Preposition P(n): 4*X <= 2*(X+Y) given 1<=X<=Y
	 * Case X=Y=1 => 4<=4 
	 * Case X=1, Y=2 => 4<6 
	 * Case X=1, Y=3 => 4<8
	 * 
	 *  by simplifying the equation the result is X**2 <= N 
	 * 
	 * Solution:
	 * 1) get the square root of N
	 * 2) iterate backwards square root of N to 1
	 * 3) find the max divisor of N, the other is N/d
	 * 4) return the perimeter
	 * 
	 * @param N
	 * @return
	 */
	static int solution2(int N) {
        int i = (int) Math.sqrt(N);
		for(; i>=1; i--) {
			if(N%i==0) {
				break;
			}
		}
		return 2*(N/i+i);
    }
	
	/**
	 * https://codility.com/demo/results/trainingWCMH6Q-PXN/ 100%
	 * 
	 * 1 An integer N is given, representing the area of some rectangle.
	 * 2 The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
	 * 3 The goal is to find the minimal perimeter of any rectangle whose area equals N
	 * 4 The sides of this rectangle should be only integers.
	 * 5 N is an integer within the range [1..1,000,000,000].
	 * 6 expected worst-case time complexity is O(sqrt(N));
	 * 7 expected worst-case space complexity is O(1).
	  
	 *
	 * Solution:
	 * 1- find multiples of N
	 * 2- find minimum perimeter using Kadane's max slice algorithm
	 * 
	 * @param N
	 * @return the minimal perimeter of any rectangle whose area is exactly equal to N.
	 */
	static int solution(int N) {
		double sqrtN = Math.sqrt(N);		
		int min_perimeter = Integer.MAX_VALUE;
		int current_perimeter = Integer.MAX_VALUE;
		for(int i=1; i<=sqrtN; i++) {
			if(N%i==0) {
				current_perimeter = 2 * (N/i + i);
				min_perimeter = Math.min(current_perimeter, min_perimeter);
			}
		}
		return min_perimeter;
	}
	
	public static void main(String[] args) {
		int result = solution2(10);
		System.out.println(result);
	}

}
