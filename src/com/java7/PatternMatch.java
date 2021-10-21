package com.java7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {

	public static void main(String[] args) {
		String text="";

	        String patternString = "\\*|[a-zA-Z\\d '()+,-./:=?@_]+";

	        Pattern pattern = Pattern.compile(patternString);

	        Matcher matcher = pattern.matcher(text);
	        boolean matches = matcher.matches();
	        
	        System.out.println(matches);
	}

}
