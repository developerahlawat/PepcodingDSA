package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class NoOfSubArrayWithBoundMax {
	// leetcode 795 https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
	  public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
	     int prev_count = 0;
	        int overall_count = 0;

	        int i = 0;
	        int j = 0;

	        while(j < nums.length) {
	            if(left <= nums[j] && nums[j] <= right) {
	                prev_count = j - i + 1;
	                overall_count += prev_count;
	            } else if(nums[j] < left) {
	                overall_count += prev_count;
	            } else {
	                prev_count = 0;
	                i = j + 1;
	            }
	            j++;
	        }
	        return overall_count;
	  }

	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    int left = scn.nextInt();
	    int right = scn.nextInt();

	    int count = numSubarrayBoundedMax(arr, left, right);
	    System.out.println(count);
	  }
	}