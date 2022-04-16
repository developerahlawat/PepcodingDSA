package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPerimeter {
	public static int largestPerimeter(int[]nums) {
	    Arrays.sort(nums);
	    
	    int peri=0;
	    
	    for(int i=nums.length-1;i>=2;i--) {
	    	if(nums[i-1]+nums[i-2]>nums[i]) {
	    		peri=nums[i]+nums[i-1]+nums[i-2];
	    		break;
	    	}
	    }
	    return peri;
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    int[]nums = new int[n];

	    for (int i = 0; i < n; i++) {
	      nums[i] = scn.nextInt();
	    }

	    System.out.println(largestPerimeter(nums));
	  }
	
}
