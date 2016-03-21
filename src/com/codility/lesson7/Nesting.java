package com.codility.lesson7;

import java.util.Stack;

public class Nesting {
	
	/**
	 * https://codility.com/demo/results/training25AFJU-CMB/ 100%
	 * 
	 * Problem, facts: 
	 * 1) A string S consisting of N characters
	 * 2) S is properly nested if:
	 * 		- S is empty;
	 * 		- S has the form "(U)" where U is a properly nested string;
	 * 		- S has the form "VW" where V and W are properly nested strings.
	 * 3) N is an integer within the range [0..1,000,000];
	 * 4) string S consists only of the characters "(" and/or ")".
	 * 5) expected worst-case time complexity is O(N)
	 * 6) expected worst-case space complexity is O(1)
	 * 
	 * Solution facts:
	 * 1) A properly nested string have N/2 open parenthesis and N/2 closing parentheses.
	 * 2) Each one of the open parenthesis are matched to a closing one.
	 * 3) If there is a match, then there is a properly nested substring
	 * 4) If S is a properly nested string, then there is N/2 matches
	 * 
	 * The idea is to use a stack keep track of the open parentheses, and any time a match occurs, then pop an
	 * element from the stack.
	 * If the string is properly nested, at the end of the loop, the stack will be empty.
	 * 
	 * @param S
	 * @return 1 if string S is properly nested and 0 otherwise.
	 */
	public static int soloution(String S) {
		if(S.isEmpty()) return 1;
		if(S.length()%2!=0) return 0; // a properly nested string is composed by a pair of elements
		Stack<Character> stack = new Stack<>();
		for(char c : S.toCharArray()) {
			if('('==c) {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) return 0;
				stack.pop();
			}
		}
		return (stack.size()==0) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		int result = soloution("()()())");
		String s = (result==1) ? "properly nested." : "not properly nested.";
		System.out.println("String S is " + s);
	}

}
