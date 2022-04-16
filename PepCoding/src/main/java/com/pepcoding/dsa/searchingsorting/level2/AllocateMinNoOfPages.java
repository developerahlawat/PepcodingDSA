package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class AllocateMinNoOfPages {
	 private static boolean isBurdenPossible(int[] pages, int burden, int m) {
	        int student = 1;
	        int sum = 0;

	        for(int i = 0; i < pages.length; i++) {
	            sum += pages[i];
	            if(sum > burden) {
	                student++;
	                sum = pages[i];
	            }
	        }
	        return student <= m;
	    }
	 
	 public static int minPages(int[]pages, int M) {
		   
	        int sum = 0;
	        int max = Integer.MIN_VALUE;
	        for(int val : pages) {
	            sum += val;
	            max = Math.max(max, val);
	        }

	        int lo = max;
	        int hi = sum;

	        int burden = Integer.MAX_VALUE;
	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if(isBurdenPossible(pages, mid, M) == true) {
	                burden = mid;
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        }
	        return burden;
	    }



	 

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    int[]arr = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    int m = scn.nextInt();

	    int ans = minPages(arr, m);
	    System.out.println(ans);
	  }
	}

