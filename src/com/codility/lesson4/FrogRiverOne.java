package com.codility.lesson4;

public class FrogRiverOne {
	
	/**
	 * https://codility.com/demo/results/trainingKFNU3G-27M/ 100%
	 * 
	 * Given that:
	 * 1) X is the final position and are in the ranges (0,X)
	 * 2) N is the size of the array A
	 * 1) the values of A are in the range (1,X)
	 * 2) the time of each value of A is their index position
	 * 3) N>X
	 * 
	 * Invariant: A[i]<=X  
	 *  
	 * @param X
	 * @param A
	 * @return
	 */
	public int solution(int X, int[] A) {
		int position = X;
        boolean[] steps = new boolean[position+1];
        for(int i=0; i<A.length; i++){
            if(!steps[A[i]]) {
                steps[A[i]] = true;
                position--;
            }
            if(position==0) return i;
        }
        return -1;
	}
	
	public static void main(String[] args) {
		FrogRiverOne frog = new FrogRiverOne();
		int time = frog.solution(6, new int[]{2,3,4,5,1,2,3,5,4,3,2,1,5,2,3,1,4,2,3,2,4,1,6});
		System.out.print("Minimum time required is: " + time);
	}

}
