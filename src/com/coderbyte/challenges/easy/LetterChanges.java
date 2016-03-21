package com.coderbyte.challenges.easy;

public class LetterChanges {
	
	/**
	 * Problem facts:
	 * 1) Replace every letter in the string with the letter following it in the alphabet
	 * 2) Then capitalize every vowel in this new string
	 * 
	 * Solution:
	 * 
	 * @param str
	 * @return the modified string
	 */
	public static String letterChanges(String str) {
		StringBuilder st = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			Character c = str.charAt(i);			
			int nextChar = Character.getNumericValue(c) + 1;			
			if(nextChar>90 && nextChar<97) {
				nextChar = 65;
			}
			else if(nextChar>122) {
				nextChar = 97;
			}
			c = Character.valueOf((char)nextChar);
			if('a'==c || 'e'==c || 'i'==c || 'o'==c || 'u'==c) {
				st.append(Character.toUpperCase(c));
			}
		}
		return st.toString();
	}
	
	public static void main(String[] args) {
		String s = letterChanges("Veni vidi vici");
		System.out.print(s);
	}

}
