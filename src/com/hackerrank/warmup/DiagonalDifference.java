package com.hackerrank.warmup;

import java.util.Scanner;

public class DiagonalDifference {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] A = new int[N][N]; 
		for(int i=0; i<N && scanner.hasNextInt(); i++) {
			for(int j=0; j<N && scanner.hasNextInt(); j++) {
				A[i][j] = scanner.nextInt();
			}
		}
		int absDiff = 0;
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<N; i++) {
			sum1+=A[i][i];			
		}
		for(int i=N-1; i>=0; i--) {
			sum2+=A[i][N-1-i];			
		}
		absDiff = Math.abs(sum1-sum2);
		System.out.print(absDiff);
	}

}
