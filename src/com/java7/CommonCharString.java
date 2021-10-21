package com.java7;

public class CommonCharString {

	public static void main(String[] args) {
		String a = "abcdefgh";
		String b = "efg";
		
	    char[] c = a.toCharArray();
	    char[] d = b.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    
	    for(Character chc : c) {
	    	if(b.indexOf(String.valueOf(chc)) != -1) {
	    	 	sb.append(chc);
	    	}
	    }
	    System.out.println("Common Charector:"+sb);
	    

	}

}
