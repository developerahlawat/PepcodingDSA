package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class ReverseVowelString {
	  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
	  
	  // leetcode 345 https://leetcode.com/problems/reverse-vowels-of-a-string/
	    private static boolean isVowel(char ch) {
	        String vowels = "aeiouAEIOU";
	        return vowels.contains(ch + "");
	    }
	    public static String reverseVowels(String s) {
	        char[] arr = s.toCharArray();

	        int left = 0;
	        int right = arr.length - 1;

	        while(left < right) {
	            // make left pointer at vowel
	            while(left < right && isVowel(arr[left]) == false) {
	                left++;
	            }

	            // make right pointer at vowel
	            while(left < right && isVowel(arr[right]) == false) {
	                right--;
	            }

	            char temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;

	            left++;
	            right--;
	        }

	        return String.valueOf(arr);
	    }
	  

	  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    String str = scn.nextLine();

	    String res = reverseVowels(str);
	    System.out.println(res);
	  }
	}