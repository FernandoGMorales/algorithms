package com.project.Euler;

public class SpecialPythagoreanTriplet {
	
	/**
	 * Dickson's method
	 * 
	 * x=r+s, y=r+t, z=r+s+t
	 * r**2 = 2st
	 * 
	 * https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples
	 * 
	 * NOT WORKING, REVIEW!!!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int triplet = 0;
		for(int i=1; i<1000; i++) {
			for(int j=i; j<1000; j++) {
				for(int k=j; k<1000; k++) {
					triplet = 3*
							i+2*j+2*k;
					if(triplet==1000) {
						int a = i+j;
						int b = i+k;
						int c = i+j+k;
						System.out.print(" a:" + a + ", b:"+ b +", c:" + c);
						break;
					}
				}
				if(triplet==1000) break;
			}
			if(triplet==1000) break;
		}
	}

}
