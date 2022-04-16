package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class FindTransactionPoint {

	  public static int findTransition(int[]arr) {
	   int indx = -1;
	        int lo = 0;
	        int hi = arr.length - 1;
	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if(arr[mid] == 1) {
	                indx = mid;
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        }
	        return indx;
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[]arr = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    System.out.println(findTransition(arr));
	  }
	 
}
