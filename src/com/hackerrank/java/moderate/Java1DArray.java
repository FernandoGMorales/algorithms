package com.hackerrank.java.moderate;

import java.util.Scanner;

public class Java1DArray {
	
	public static int solution(int[] A, int jump) {
		int result = 0;
		int backSteps = 0;
		for(int i=1; i<A.length; i++) {
			while(i<A.length && A[i]==1 && A[i-1]==0) {
				i += jump-1;
			}
			if(i>=A.length) {
				result = 1;
				break;
			}
			else if(A[i]==1) {
				while(i>=0 && A[--i]==1) {
					backSteps++;
				}
				if(i<=0) {
					result = 0;
					break;
				}
				else if(backSteps>=jump) {
					result = 0;
					break;
				}				
			}
			else if(i==A.length-1){
				result = 1;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();		
		for(int j=0; j<testCases; j++) {
			int N = scanner.nextInt();
			int jump = scanner.nextInt();
			int[] A = new int[N];						
			for(int i=0; i<N; i++) {
				A[i] = scanner.nextInt();
			}
			int result = solution(A,jump);
			System.out.println((result==1) ? "YES" : "NO");
		}
	}

}
