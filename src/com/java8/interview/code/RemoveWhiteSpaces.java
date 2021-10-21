package com.java8.interview.code;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		String s = "ABC D EF ";
		StringBuilder output = new StringBuilder();
		char[] cArr = s.toCharArray();
		for(char c : cArr) {
			if(!Character.isWhitespace(c)) {
				output.append(c);
			}
		}
		System.out.println(output);
	}

}
