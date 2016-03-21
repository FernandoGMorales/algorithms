package com.codility.lesson4;

public class PermCheck {
	
	/**
	 * https://codility.com/demo/results/training4YUHYS-HDW/ 100% 17 minutes
	 * 
	 * Facts:
	 * 1) A permutation is a sequence containing each element from 1 to N once, and only once.
	 * 2) A non-empty zero-indexed array A consisting of N integers is given
	 * 3) N is an integer within the range [1..100,000];
	 * 4) each element of array A is an integer within the range [1..1,000,000,000].
	 * 
	 * Invariant: the sequence is in the range A[0] to A[N-1]
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int result=1;
		int[] count = new int[A.length+1];
        for(int i=0; i<A.length; i++) {
        	if(A[i]>A.length) return 0;
        	if(count[A[i]]>0) return 0;
        	count[A[i]]++;
        }
        for(int i=1; i<count.length; i++) {
        	if(count[i]==0) {
        		result =0;
        		break;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int result = solution(new int[]{1});		
		String string = result==1 ? "a permutation." : "not a permutation.";
		System.out.println("The array is " + string);
	}
 
}
