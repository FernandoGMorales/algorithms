package com.codility.lesson3;

public class PermMissingElem {
	
	/**
	 * 
	 * https://codility.com/demo/results/trainingAYK3JX-3HT/ 100%
	 * 
	 * See counting rules.
	 * 
	 * the total amount of a sequence of natural numbers can be calculated as follows
	 *   1,  2,  3,...,  n-1,n
	 * + n, n-1, n-2,..., 2, 1
	 *  n+1,n+1, n+1,..., n+1, n+1
	 *  
	 *  Total amount or cardinality of this set is: (n*(n+1))/2
	 *  
	 */
	public static int solution(int[] A) {
	    long n = A.length + 1;
	    long total = (n*(n+1))/2;
	    for(int i : A) {
	    	total-=i;
	    }
	    return (int)total;
	}
	
	public static void main (String[] args) {
		int missingElement = solution(new int[]{1,2,3,4,6});
		System.out.println("Missing element is: " + missingElement);
	}

}
