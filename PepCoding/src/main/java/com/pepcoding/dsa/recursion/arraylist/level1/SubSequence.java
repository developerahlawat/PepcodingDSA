package com.pepcoding.dsa.recursion.arraylist.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequence {
	 public static void main(String[] args) throws Exception {
	        Scanner scn=new Scanner(System.in);
	        String str=scn.next();
	        ArrayList<String> res=gss(str);
	        System.out.println(res);
	    }

	    public static ArrayList<String> gss(String str) {
	    	if(str.length() ==0) {
	    		ArrayList<String> bres=new ArrayList<>();
	    		bres.add("");
	    		return bres;
	    	}	    	
	        char ch=str.charAt(0);
	        String ros=str.substring(1);
	        ArrayList<String> rres=gss(ros);	        
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
