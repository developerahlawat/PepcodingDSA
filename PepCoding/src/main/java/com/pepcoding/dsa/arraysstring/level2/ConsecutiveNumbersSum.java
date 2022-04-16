package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class ConsecutiveNumbersSum {
	// ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
	  public static int consecutiveNumbersSum(int n) {
	      int count = 0;
	     for(int k = 1; k * (k - 1) < 2 * n; k++) {
	            int numerator = n - (k* (k - 1) / 2);
	            if(numerator % k == 0) {
	                count++;
	                // System.out.println(numerator / k + " " + k);
	            }
	                
	        }       
	        return count; 
	  }

	  // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int num = scn.nextInt();
	    int res = consecutiveNumbersSum(num);
	    System.out.println(res);
	  }
	}