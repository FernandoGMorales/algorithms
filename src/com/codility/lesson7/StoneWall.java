package com.codility.lesson7;

import java.util.Stack;

public class StoneWall {
	
	/**
	 * https://codility.com/demo/results/trainingF3ZNAJ-ZHU/ 100%
	 * 
	 * Problem facts:
	 * 1) You are given a zero-indexed array H of N positive integers specifying the height of the wall, 
	 *    you are going to build a stone wall.
	 * 2) The wall should be straight and N meters long, and its thickness should be constant
	 * 3) it should have different heights in different places
	 * 4) The height of the wall is specified by a zero-indexed array H of N positive integers.
	 * 5) H[I] is the height of the wall from I to I+1 meters to the right of its left end
	 * 6) The wall should be built of cuboid stone blocks
	 * 7) N is an integer within the range [1..100,000];
	 * 8) each element of array H is an integer within the range [1..1,000,000,000].
	 * 9) expected worst-case time complexity is O(N);
	 * 10) expected worst-case space complexity is O(N)
	 * 
	 * Solution facts:
	 * A) The wall is of length N and is built of cuboid blocks.
	 * B) The length of a block is given by the sum of the lengths of all successive blocks with 
	 * heights >= to the height of current block.
	 * C) Given (B) there are three cases to consider to find out the # of blocks (b1: block1, h1:height1, 
	 * b2:block2, h2:height2):
	 * 		a) h1 > h2: means b1 > b2, there are two different blocks, b1 is bounded, therefore we count it
	 * 		b) h1 < h2: means b1 < b2, therefore b1 extends under b2, there are two different blocks, none 
	 * 		   of the blocks are bounded yet, therefore, we cannot count them yet.
	 * 		c) h1 == h2: means b1 == b2, they are both part of one block and the block is not bounded yet,  
	 * 		   therefore, we cannot count it yet.
	 * D) The total number of blocks are the sum of blocks counted in step (a) and the remaining ones in the stack,
	 * after the loop exits.
	 * 
	 * @param A
	 * @return the minimum number of blocks needed to build the wall.
	 */
	public static int solution(int[] H) {
		int blocks = 0;
		Stack<Integer> stack = new Stack<>();
		for(int height : H) {			
			while(!stack.isEmpty() && height<stack.peek()) {
				stack.pop();
				blocks++; // case a: count the block
			}
			if(stack.isEmpty() || height>stack.peek()) {
				stack.push(height);
			}
			// else height==stack.peek(), continue
		}		
		return blocks+=stack.size();  /* there may still be some blocks unbounded (yet in the stack), 
										 which, by this time are bounded by N */
	}
	
	public static void main(String[] args) {
		int blocks = solution(new int[]{1,2,3,4,5,6,7,8,9});
		System.out.println("# of blocks: " + blocks);
	}

}
