package com.project.Euler;

import java.io.File;
import java.util.Scanner;

public class LargestProductInAGrid {
	
	/**
	 * BAD DESIGN, BAD IMPLEMENTATION, REVIEW!!!
	 * 
	 * Problem:
	 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
	 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
	   What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, 
	   or diagonally) in the 20×20 grid?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = new int[20][20];
		try {
			Scanner sc = new Scanner(new File("/home/fernando/tmp/grid.txt"));			
			for(int i=0; i<20 && sc.hasNextLine(); i++) {
				for(int j=0; j<20 && sc.hasNextInt(); j++) {
					grid[j][i] = sc.nextInt();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(grid.length==0) return;
		int maxProd = 1;
		int currentProd = 1;
		
		//Rows
		for(int i=0; i<20; i++) { // rows
			for(int j=0; j<20; j++) { // columns
				int k = 0;
				while(k<4) {
					currentProd*=grid[j++][i];
					k++;					
				}
				maxProd = Math.max(currentProd, maxProd);
				currentProd = 1;				
			}			
		}
		
		//Columns
		for(int j=0; j<20; j++) {
			for(int i=0; i<20; i++) { // columns
				int k = 0;
				while(k<4) {
					currentProd*=grid[j][i++];
					k++;
				}
				maxProd = Math.max(currentProd, maxProd);
				currentProd = 1;
			}		
			
		}
		
		// Left-Right diagonals 
		for(int i=0; i<20; i++) {
			for(int j=i; j<20; j++) { // columns
				int k = 0;
				while(k<4 && j<20) {
					currentProd*=grid[j][j];
					k++;
					j++;
				}
				maxProd = Math.max(currentProd, maxProd);
				currentProd = 1;								
			}			
		}
		
		// Right-Left diagonals
		for(int i=19; i>=0; i--) {
			for(int j=i; j>=0; j--) { // columns
				int k = 0;
				while(k<4 && j<20) {
					currentProd*=grid[j][j];
					k++;
					j++;
				}
				maxProd = Math.max(currentProd, maxProd);
				currentProd = 1;								
			}			
		}		
		
		System.out.print(maxProd);
		
	}

}
