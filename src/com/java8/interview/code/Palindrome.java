package com.java8.interview.code;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("Is Palindrome:"+checkPalindromeString("Kayak"));
		System.out.println("Reversed:"+revString("Ghosh"));
	}

	static boolean  checkPalindromeString(String input) {
		boolean result = true;
		int length = input.length();
		for(int i=0; i < length/2; i++) {
			if(input.charAt(i) != input.charAt(length-i-1)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	static String  revString(String input) {
		StringBuilder sb = new StringBuilder(input);
		return sb.reverse().toString();
	}
}
