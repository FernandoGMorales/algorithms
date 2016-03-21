package com.codility.lesson2;

public class CyclicRotation {
	
	/**
	 * https://codility.com/demo/results/trainingEFSEZG-BCK/ 100%
	 * 
	 * @param A
	 * @param k
	 * @return
	 */
	public static int[] solution(int[] A, int k) {
		int[] rotatedArray = new int[A.length];
		for(int i=0; i<A.length; i++) {
			int j=i+k;
			while(j>=A.length) {
				j-=A.length;								
			}
			rotatedArray[j]=A[i];			
		}
		return rotatedArray;
	}
	
	public static void main(String[] args) {
		int[] A = solution(new int[]{3,6,9}, 111);
		for(int i: A) {
			System.out.print(" " + i);
		}
	}

}
