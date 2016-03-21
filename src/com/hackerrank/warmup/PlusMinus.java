package com.hackerrank.warmup;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		int i=0;
		while(scanner.hasNextInt()) {
			A[i++] = scanner.nextInt();
		}
		double pos=0, neg=0, zero=0;
		for(i=0; i<N; i++) {
			if(A[i]>0) {
				pos++;
			}
			else if(A[i]<0) {
				neg++;
			}
			else {
				zero++;
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.######");
		df.setRoundingMode(RoundingMode.CEILING);
		
		pos = (double)pos/(double)N;
		neg = (double)neg/(double)N;
		zero = (double)zero/(double)N;
		
		System.out.println(df.format(pos));
		System.out.println(df.format(neg));
		System.out.println(df.format(zero));
	}

}
