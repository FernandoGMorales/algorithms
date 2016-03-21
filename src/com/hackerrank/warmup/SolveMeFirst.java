package com.hackerrank.warmup;

import java.util.Scanner;

public class SolveMeFirst {

	public static int solveMeFirst(int[] A) {
		if(A==null) return 0;
		if(A.length==1) return A[0];
		int sum = 0;
		for(int i : A) {
			sum+=i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] A = new int[2];
		while(scanner.hasNextInt()) {
			A[0] = scanner.nextInt();
		}
		int avg = solveMeFirst(A);
		System.out.print(avg);
	}

}
