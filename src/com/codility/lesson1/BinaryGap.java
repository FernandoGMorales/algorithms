package com.codility.lesson1;

public class BinaryGap {
	
	/**
	 * The idea is that any decimal number can be expressed in the following way:
	 * 1- divide the number by 2
	 * 2- add 0 or 1 depending on the remainder.
	 * 
	 *    IE: 13/2= 6 -> remainder 1
	 *    	  6/2 = 3 -> remainder 0
	 *        3/2 = 1 -> remainder 1
	 *        1/2 = 0 -> remainder 1 (this is the most significant digit)
	 *        
	 *        so 13 in binary is equal to 1101
	 *        
	 *        To reconstruct the binary to decimal just sum the corresponding term (1x2**n)
	 *        In the case of 1101 will be: 1x2**3 + 1x2**2 + 1x2**0 = 8+4+1 = 13 
	 * 
	 * https://codility.com/demo/results/trainingMYE5BR-47E/ 100%
	 * 
	 * https://codility.com/demo/results/trainingUD74SG-TBX/ 100%
	 * 
	 * @param n
	 * @return
	 */
	public static int solution(int n) {
		System.out.println("Number is: " + n);
		int binaryGap = 0;
		int currentGap = 0;
		boolean flag = false;
		StringBuilder binaryRep = new StringBuilder();
		if(n==0) return 0;
		for(int i=n; i>0; i/=2) {
			if(i%2==0) {
				currentGap = flag ? currentGap + 1 : 0;
				binaryRep.insert(0,0);
			}
			else {
				binaryGap = Math.max(currentGap, binaryGap);
				binaryRep.insert(0,1);
				currentGap = 0;
				flag = true;
			}
		}
		System.out.println("Binary rep. of number is: " + binaryRep.toString());
		return binaryGap;
	}
	
	public static void main(String[] args) {
		int gap = solution(999999999*999999999);
		System.out.println("Max gap is: " + gap);		
	}
 
}
