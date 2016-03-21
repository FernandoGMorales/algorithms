package com.codility.lesson7;

import java.util.Stack;

public class Fish {
	
	/**
	 *  https://codility.com/demo/results/trainingTMMGQG-8C6/ 100%
	 *  
	 * Problem facts:
	 * 1) two non-empty zero-indexed arrays A and B consisting of N integers.
	 * 2) Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.
	 * 3) The fish are numbered from 0 to N − 1.
	 * 4) If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q
	 * 5) Fish number P is represented by A[P] and B[P].
	 * 6) Array A contains the sizes of the fish. All its elements are unique.
	 * 7) Array B contains the directions of the fish. It contains only 0s(upstream) and/or 1s(downstream)
	 * 8) two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0
	 * 		-If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
	 *      -If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
	 * 9) N is an integer within the range [1..100,000];
	 * 10) each element of array A is an integer within the range [0..1,000,000,000];
	 * 11) each element of array B is an integer that can have one of the following values: 0, 1;
	 * 12) the elements of A are all distinct.
	 * 13) expected worst-case time complexity is O(N);
	 * 14) expected worst-case space complexity is O(N) 
	 * 
	 * Solution:
	 * Mantain a stack of living fishes, living fishes are those that survives collisions (0,1), or flow in the 
	 * same direction of bigger fishes (0,0 - 1,1), or just never collide (1,0). 
	 * Two possible cases
	 * A) 0,1 (these is a collision)
	 * B) 0,0 - 1,0 - 1,1 (these are not collisions)
	 * 
	 * Why to use a stack? Because of the nature of the stack, it is a LIFO dynamic set (last in first out)
	 * I'll use the LIFO feature of the stack to keep track of the living fishes
	 * If there is a collision and the new fish is bigger, I'll continue popping out fishes until, either, the
	 * stack is empty or there's a bigger fish downstream.  
	 * 
	 * @param A
	 * @param B
	 * @return the number of fish that will stay alive.
	 */
	public static int solution(int[] A, int[] B) {
		int N = A.length;
		if (N==1) return 1;
		Stack<Integer> alive = new Stack<>(); // the stack of alive fishes
		for(int i=0; i<N; i++) {
			int size = A[i];
			int dir = B[i];
			if(alive.isEmpty()) {
				alive.push(i);
			}
			else { 
				while(!alive.isEmpty() && (B[alive.peek()]==1 && dir==0) && A[alive.peek()]<size) {
					alive.pop(); // 1,0 collide and wins new fish					
				}
				if(alive.isEmpty()) { // new fish beats all fishes and is the only one in the stack
					alive.push(i);
				}
				else {
					if(B[alive.peek()]==1 && dir==0) { // there was a collision and a fish in the stack wins
						continue;
					}
					else {
						alive.push(i); // there is no collision, the fish is added to the stack
					}
				}
			}
		}		
		return alive.size();
	}
	
	public static void main(String[] args) {
		int result = solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0});
		System.out.print("Result: " + result);
	}

}
