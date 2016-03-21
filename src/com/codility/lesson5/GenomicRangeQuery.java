package com.codility.lesson5;

public class GenomicRangeQuery {
	
	/**
	 *  https://codility.com/demo/results/trainingSZFXXM-NFP/ 100%
	 * 
	 * Problem facts:
	 * 1) Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4
	 * 2) The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
	 * 3) There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
	 * 4) The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides 
	 *     contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
	 * 5) N is an integer within the range [1..100,000];
	 * 6) M is an integer within the range [1..50,000];
	 * 7) each element of arrays P, Q is an integer within the range [0..N − 1];
	 * 8) P[K] ≤ Q[K], where 0 ≤ K < M;
	 * 9) string S consists only of upper-case English letters A, C, G, T.
	 * 
	 * Solution:
	 * The trick is to count nucleotides in a 2D array, in this way, we are counting the amount of a given type of
	 * nucleotide at current index. Later we can find what nucleotides are in the range P[i],Q[i] by comparing 
	 * amounts of nucleotides, if some of the nucleotides amount have changed, then those nucleotides are in the 
	 * range P[i],Q[i].
	 * 
	 * @param S
	 * @param P
	 * @param Q
	 * @return an array consisting of M integers specifying the consecutive answers to all queries.
	 */	
	
	public static int[] solution(String S, int[] P, int[] Q) {
		int M = P.length;
		int N = S.length();
		
		/*
		 * 1) Compute the indices of the nucleotides in a 2D array.
		 * 
		 */
		int[][] nucleotidesByPosition = new int[N][4];
		for (int i = 0; i < N; i++) {
			switch (S.charAt(i)) {
			case 'A':
				nucleotidesByPosition[i][0]=1;
				break;
			case 'C':
				nucleotidesByPosition[i][1]=1;
				break;
			case 'G':
				nucleotidesByPosition[i][2]=1;
				break;
			case 'T':
				nucleotidesByPosition[i][3]=1;
				break;
			default:
				break;
			}
		}
		
		/*
		 * 2) Compute the prefix sums.
		 * 
		 */
		int[][] prefixSum = new int[N+1][4]; // N+1 because first prefix sum is 0
		for(int i=1; i<N+1; i++) { // again, this starts from 1 because prefix of 0 is 0
			for(int j=0; j<4; j++) {
				prefixSum[i][j] = prefixSum[i-1][j] + nucleotidesByPosition[i-1][j];				
			}
		}
		
		/*
		 * 3) To find the nucleotide with the lowest factor just do the following check:
		 * ( prefixSum[q+1][j] - prefixSum[p][j] ) > 0, this means that in the range p,q+1 there is an increment 
		 * of the nucleotide pointed by j. 
		 * 
		 */
		int[] answers = new int[M];        
		for(int i=0; i<M; i++) {
			int p = P[i];
			int q = Q[i]; 
			for(int j=0; j<4; j++) {
				if(prefixSum[q+1][j]-prefixSum[p][j]>0) {
					answers[i]=j+1;
					break;
				}
			}
		}
        return answers;
    }
	
	public static void main(String[] args) {
		int[] answers = solution("CTGAGGCTTA",new int[]{0,0,8},new int[]{2,3,8});
		for(int a : answers) {
			System.out.print(" " + a);
		}
	}

}
