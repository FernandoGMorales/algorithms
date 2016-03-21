package com.codility.lesson7;

import java.util.Stack;

public class Brackets {
	
	/**
	 *  https://codility.com/demo/results/trainingDH6658-TDH/ 100%
	 *  
	 * Problem facts:
	 * 1) A string S consisting of N characters is given
	 * 2) S is properly nested if:
	 * 		-S is empty;
	 *  	-S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
	 *		-S has the form "VW" where V and W are properly nested strings.
	 * 3) N is an integer within the range [0..200,000];
	 * 4) string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
	 * 5) expected worst-case time complexity is O(N);
	 * 6) expected worst-case space complexity is O(N)
	 * 
	 * Solution:
	 * The idea is to iterate over the string and push opening brackets, then each time a closing bracket appears
	 * it will be matched with the last opening match stacked, if both are of the same type, then pop that char,
	 * otherwise return 0.
	 * If the string S is properly nested the remaining stack will be empty. 
	 * 
	 * There are three cases to analize:
	 * 1) The stack is empty, push the first char.
	 * 2) The stack is not empty, peek the last char and it is the opening bracket of current closing bracket, then
	 * pop the char from the stack.
	 * 3) The stack is not empty, peek the last char and it isn't the opening bracket of current closing bracket, 
	 * return 0, because the string is malformed.
	 * 
	 * @param S
	 * @return 1 if S is properly nested and 0 otherwise.
	 */
	public static int solution(String S) {		
		if(S.isEmpty()) return 1; // pay attention to corner case 1
		if(S.length()==1) return 0; // and 2
		if(S.length()%2!=0) return 0; // a properly nested string is composed by a pair number of elements
		
		Stack<Character> stack = new Stack<>();		
		
		for(int i=0; i<S.length(); i++) {
			char current = S.charAt(i);
			switch (current) {
				case '}':
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					} 
					else return 0;
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} 
					else return 0;
					break;
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} 
					else return 0;
					break;
				default:
					stack.push(current);
					break;
			}	
		}
		return stack.size()==0 ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String S = "[";
		int result = solution(S);
		System.out.println(S + ((result==1) ? " is properly nested." : " is not properly nested."));
	}

}
