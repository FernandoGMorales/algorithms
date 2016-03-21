package com.hackerrank.warmup;

import java.util.Scanner;

public class Staircase {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		for(int column=height-1; column>=0; column--) { 
			for(int row=column; row<height; row++) { 
				System.out.print('#');
			}
			System.out.println();
		}
	}

}
