package com.hackerrank.warmup;

import java.util.Scanner;

public class SimpleArraySum {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] A = new int[scanner.nextInt()];
		int i = 0;
		while(scanner.hasNextInt()) {
			A[i++] = scanner.nextInt();
		}
		int sum = 0;
		for(int j=1; j<=A[0]; j++) {
			sum+=A[j];
		}
		System.out.print(sum);
	}

}
