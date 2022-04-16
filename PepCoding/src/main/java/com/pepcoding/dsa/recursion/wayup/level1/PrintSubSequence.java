package com.pepcoding.dsa.recursion.wayup.level1;

import java.util.Scanner;

public class PrintSubSequence {
	 public static void main(String[] args) throws Exception {
	        Scanner scn=new Scanner(System.in);
	        String str=scn.nextLine();
	        printSS(str,"");

	    }

	    public static void printSS(String ques,String ans) {
	    	
	    	if(ques.length() ==0) {
	    		System.out.println(ans);
	    		return;
	    	}
	    	
	        char ch=ques.charAt(0);
	        String ros=ques.substring(1);
	        
	        printSS(ros,ans+ch);

	        printSS(ros,ans+"");
	        return ;
	    }

}
