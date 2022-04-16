package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class FirstBadVersion {
	public static int firstBadVersion(int n) {
	    int fb = 0;
	        int lo = 0;
	        int hi = n;
	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if(isBadVersion(mid) == true) {
	                fb = mid;
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        }
	        return fb;
	  }

	  static int bad = 0;
	  public static boolean isBadVersion(int val) {
	    if (val >= bad) {
	      return true;
	    }
	    else {
	      return false;
	    }
	  }

	  public static void solve(int n, int fbv) {
	    bad = fbv;
	    System.out.println(firstBadVersion(n));
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int fbv = scn.nextInt();

	    solve(n, fbv);
	  }
	
}
