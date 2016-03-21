package com.codility.lesson8;

import common.util.dynamicSets.dataStructures.Stack;

public class Dominator {
	
	/**
	 * https://codility.com/demo/results/training3JTQMH-NKK/ 100%
	 * 
	 * Problem facts:
	 * 1) A zero-indexed array A consisting of N integers is given
	 * 2) N is an integer within the range [0..100,000];
	 * 3) each element of array A is an integer within the range [−2,147,483,648..2,147,483,647]
	 * 4) expected worst-case time complexity is O(N);
	 * 5) expected worst-case space complexity is O(1) 
	 * 6) the dominator is the element that occurs more than N/2 
	 * 
	 * @param A
	 * @return returns index of any element of array A in which the dominator of A occurs or return −1 
	 * if array A does not have a dominator.
	 */
	public static int solution(int[] A) {
		int index = -1;
		int N = A.length;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			if(stack.isEmpty() || A[stack.peek()]==A[i]) {
				stack.push(i);				
			}
			else if(!stack.isEmpty() && A[stack.peek()]!=A[i]){
				stack.pop();				
			}			
		}
		if(!stack.isEmpty()) { // if the stack is NOT EMPTY, it could be a dominator
			int candidate = A[stack.peek()];
			int counter = 0;
			for(int i : A) {
				if(i==candidate) {
					counter++;
				}
			}
			index = (counter>N/2) ? stack.pop() : -1;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int index = solution(new int[]{2, 1, 1, 3});
		System.out.print(index);
		
		index = solution(new int[]{});
		assert(index==-1);
		
	}

}
