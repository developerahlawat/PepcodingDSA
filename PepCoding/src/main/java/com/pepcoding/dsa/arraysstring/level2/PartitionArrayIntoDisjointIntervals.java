package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class PartitionArrayIntoDisjointIntervals {
	// ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
	// leetcode 915. https://leetcode.com/problems/partition-array-into-disjoint-intervals/
    // method 1, O(n) space
    public static int partitionDisjoint1(int[] nums) {
	    int n = nums.length;

	        // 1. right min creation
	        int[] rightmin = new int[n];
	        rightmin[n - 1] = nums[n - 1];
	        for(int i = n - 2; i >= 0; i--) {
	            rightmin[i] = Math.min(nums[i], rightmin[i + 1]);
	        }

	        // 2. travel and solve, also maintaion left max simultaneously
	        int leftmax = Integer.MIN_VALUE;
	        int ans = 0;
	        for(int i = 0; i < n -  1; i++) {
	            leftmax = Math.max(leftmax, nums[i]);
	            if(leftmax <= rightmin[i + 1]) {
	                ans = i;
	                break;
	            }
	        }
	        return ans + 1;
	  }
    
    // method 2 -> with O(1) space
    public static int partitionDisjoint2(int[] nums) {
        int leftmax = nums[0];
        int maxInRun = nums[0];
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > maxInRun) {
                maxInRun = nums[i];
            } else if(nums[i] < leftmax) {
                ans = i;
                leftmax = maxInRun;
            }
        }
        return ans + 1;
    }

	  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    int len1 = partitionDisjoint1(arr);
	    int len2 = partitionDisjoint2(arr);
	    System.out.println(len1);
	    System.out.println(len2);
	  }
	}
