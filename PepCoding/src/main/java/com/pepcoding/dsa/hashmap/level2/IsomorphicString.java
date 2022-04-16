package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class IsomorphicString {
	  // isomorphic strings
	   public static boolean isIsomorphic(String s, String t) {
	       if(s.length() != t.length()) return false;

	       HashMap<Character, Character> map = new HashMap<>();
	       HashSet<Character> set = new HashSet<>();

	       for(int i = 0; i < s.length(); i++) {
	           char ch1 = s.charAt(i);
	           char ch2 = t.charAt(i);

	           if(map.containsKey(ch1) == true) {
	               if(map.get(ch1) != ch2) return false;
	           } else {
	               if(set.contains(ch2) == true) {
	                   return false;
	               } else {
	                   map.put(ch1, ch2);
	                   set.add(ch2);
	               }
	           }
	       }
	       return true;
	   }

	   
	   
	public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String A= scn.next();
        String B= scn.next();
        System.out.print(isIsomorphic(A, B));
    }
    // -----------------------------------------------------
	 // This is a functional problem. Only this function has to be written.
	 // This function takes as input 2 strings.
	 // It should return a boolean value.

   
}