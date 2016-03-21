package com.project.Euler;

public class SmallestMultiple {
	
	public static void main(String[] args) {
		int n = 2520;
		int result = 0;
		for(int i=2520; i<=Integer.MAX_VALUE; i+=2) {
			int j=2;
			while(i%j==0) {
				j++;
			}
			if(j>=20) {
				result = i;
				break;
			}
		}
		System.out.print(result);
	}

}
