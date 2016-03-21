package com.codility.lesson2;

public class OddOccurrencesInArray {
	
	/**
	 * If all the elements except one is paired, we can use xor for this problem and just one scanning is okay. 
	 * Since A xor A = 0, and B xor 0 = B, if we keep on performing xor for all the values, the one left after 
	 * iteration is the value unpaired.
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int unpaired = 0;
		for(int i : A) {
			unpaired^=i;
		}
		return unpaired;
	}
	
	public static void main(String[] args) {
		int unpaired = solution(new int[]{9,3,9,3,3});
		System.out.println("Unpaired number is: " + unpaired);
	}

}
