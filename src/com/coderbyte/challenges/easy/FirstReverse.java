package com.coderbyte.challenges.easy;

import java.util.Scanner;

public class FirstReverse {
	
	public static String FirstReverse(String str) {		  
	    char[] word = str.toCharArray();
	    char[] reversed = new char[word.length];
	    for(int i=0; i<word.length; i++) {
	    	reversed[i]=word[word.length-i-1];
	    }	    
	    return String.copyValueOf(reversed);	    
	  } 
	  
	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	    System.out.print(FirstReverse(s.nextLine())); 
	  }  

}
