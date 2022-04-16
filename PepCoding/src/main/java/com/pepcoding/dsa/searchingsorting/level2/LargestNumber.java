package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
	public static String largestNumber(int[]arr) {
	     String[] starr = new String[arr.length];
	        for(int i = 0; i < arr.length; i++) {
	            starr[i] = "" + arr[i];
	        }

	        Arrays.sort(starr, (a, b) -> {
	            long d1 = Long.parseLong(a + b);
	            long d2 = Long.parseLong(b + a);

	            if(d1 > d2) {
	                return 1;
	            } else if(d1 < d2) {
	                return -1;
	            } else {
	                return 0;
	            }
	        });

	        StringBuilder res = new StringBuilder();
	        for(int i = starr.length - 1; i >= 0; i--) {
	            res.append(starr[i]);
	        }
	        String ans = res.toString();
	        return ans.charAt(0) == '0' ? "0" : ans;
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[]nums = new int[n];

	    for (int i = 0; i < n; i++) {
	      nums[i] = scn.nextInt();
	    }

	    System.out.println(largestNumber(nums));
	  }
}
