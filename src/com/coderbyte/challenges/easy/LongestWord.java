package com.coderbyte.challenges.easy;

public class LongestWord {
	
	public static String longestWord(String sen) {

		String[] words = sen.replaceAll("[^a-zA-Z ]", "").split(" ");
		int lenght = words[0].length();
		String maxWord = words[0];
		for(int i=1; i<words.length; i++) {			
			if(words[i].length()>lenght) {
				maxWord=words[i];
				lenght=words[i].length();
			}
		}		 

		return maxWord;

	}
	
	public static String removePunctuation(String sen) {
		String aux = null;
		aux = sen.replaceAll("[^a-zA-Z ]", ""); // remove all non letter chars
		return aux;
	}
	
	public static void main(String[] args) {
//		String word = longestWord("Mi barba tiene tres pelos");
//		System.out.println("Word: " + word);
		String sen = "De la punta de aquel cerro, Atahualpa.";
		String res = removePunctuation(sen);
		System.out.println(res);
	}
	
	

}
