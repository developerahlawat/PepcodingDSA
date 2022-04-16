package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class FindRotationCount {
	public static int findRotationCount(int[]arr) {
	       int lo = 0;
	        int hi = arr.length - 1;

	        while(lo < hi) {
	            int mid = lo + (hi - lo) / 2;
	            if(arr[mid] < arr[hi]) {
	                hi = mid;
	            } else {
	                lo = mid + 1;
	            }
	        }
	        return hi;
	    }

	    public static void main(String[]args) {
	        //input work
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();

	        int[]arr = new int[n];
	        for(int i = 0 ; i < n; i++) {
	            arr[i] = scn.nextInt();
	        }

	        int ans = findRotationCount(arr);
	        System.out.println(ans);
	    }
	
}
