package com.pepcoding.dsa.recursion.arraylist.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequence1 {
	/*
	 * 
subsequence-->abc--> ---,--c,-b-,-bc,a--,a-c,ab-,abc
substring --> abc--> a,ab,abc,b,bc,c
	 */
	 public static void main(String[] args) throws Exception {
	        Scanner scn=new Scanner(System.in);
	        String str=scn.next();
	        ArrayList<String> res=gss(str);
	        System.out.println(res);
	    }

	    public static ArrayList<String> gss(String str) {
	    	/*
	faith-    	 bc->[--,-c,b-,bc]
	result- 	 abc->[---,--c,-b-,-bc,a--,a-c,ab-,abc]
	    	 */
	    	if(str.length() ==0) {
	    		ArrayList<String> bres=new ArrayList<>();
	    		bres.add("");
	    		return bres;
	    	}	    	
	        char ch=str.charAt(0);//a
	        String ros=str.substring(1);//ab
	        ArrayList<String> rres=gss(ros);//[--,-c,b-,bc]	        
	        ArrayList<String> mres=new ArrayList<>();
	        for(String rstr:rres) {
	        	mres.add(""+rstr);
	        }
	        for(String rstr:rres) {
	        	mres.add(ch+rstr);
	        }
	        return mres;
	    }
}
