package com.codility.lesson3;

public class FrogJmp {
	
	/**
	 * https://codility.com/demo/results/trainingZMUS5Z-5C4/ 100%
	 * 
	 * Pay attention to the range of the input variables, the type of the variables and the operations with those
	 * variables.
	 * 
	 * @param x
	 * @param y
	 * @param d
	 * @return
	 */
	public int solution(int x, int y, int d) {
		return (int)Math.ceil((double)(y-x)/d);		
	}
	
	public static void main(String[] args) {
		FrogJmp frog = new FrogJmp();
		int jumps = frog.solution(1, 2, 30);
		System.out.println("# of jumps: " + jumps);
	}

}
