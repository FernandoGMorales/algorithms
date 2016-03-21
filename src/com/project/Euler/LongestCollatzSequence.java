package com.project.Euler;

public class LongestCollatzSequence {
	
	public static void main(String[] args) {
		int upper_bound = 1_000_000;
		int chain_length = 0;
		int longest_chain = 0;
		int longest_chain_start_number = upper_bound;
		for(int start_number=upper_bound; start_number>0; start_number--) {
			long current_number = (long)start_number; // pay attention to overflows!!!
			while(current_number>1) {
				if(current_number%2==0) {
					current_number = current_number/2;
				}
				else {
					current_number = (3*current_number)+1;
				}
				chain_length++;
			}
			if(chain_length>longest_chain) {
				longest_chain = chain_length;
				longest_chain_start_number = start_number;
			}			
			chain_length = 0;
		}
		System.out.print("#" + longest_chain_start_number + ", chain lenght: " + longest_chain);
	}

}
