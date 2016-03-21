package com.hackerrank.warmup;

import java.util.Scanner;

public class AVeryBigSum {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long[] A = new long[scanner.nextInt()];
		int i = 0;
		while(scanner.hasNextLong()) {
			A[i++] = scanner.nextLong();
		}
		long sum = 0;
		for(int j=0; j<A.length; j++) {
			sum+=A[j];
		}
		System.out.print(sum);
	}

}
