package com.codility.lesson8;

public class EquiLeader {
	
	/**
	 * 
	 * REVIEW!!!!
	 * Problem facts:
	 * 1) A non-empty zero-indexed array A consisting of N integers is given
	 * 2) The leader of this array is the value that occurs in more than half of the elements of A.
	 * 3) An equileader is an index S such that 0 ≤ S < N − 1
	 * 4) and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] 
	 *    have leaders of the same value.
	 * 5) N is an integer within the range [1..100,000];
	 * 6) each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
	 * 7) expected worst-case time complexity is O(N);
	 * 8) expected worst-case space complexity is O(N)
	 * 
	 * Solution:
	 * 
	 * @param A
	 * @return the number of equi leaders.
	 */
	public static int solution(int[] A) {
		int equileaders = 0;
		if(A.length==1) return equileaders;
		int leaderIx = Dominator.solution(A);
		if(leaderIx==-1) return equileaders;
		int N = A.length;		
		int leader = A[leaderIx];
		
		int leaders = 0;
		for(int i : A) {
			if(i==leader) leaders++;
		}
		
		int lastIndex = -1;
		int count = 0;
		int j=0;
		while(j<N) {
			if(A[j]==leader) {
				count++;
			}
			if(count>(j+1)/2 && j>lastIndex) {
				equileaders += (leaders-count>(N-(j+1))/2) ? 1 : 0;
				lastIndex=j;
				count=0;
				j=0;				
			}
			j++;
		}		
		return equileaders;
	}
	
	public static void main(String[] args) {
		int equileaders = solution(new int[]{4, 4});
		System.out.print(equileaders);
	}

}
