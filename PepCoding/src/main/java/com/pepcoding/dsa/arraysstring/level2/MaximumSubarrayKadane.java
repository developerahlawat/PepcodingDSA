package com.pepcoding.dsa.arraysstring.level2;

public class MaximumSubarrayKadane {
	 // leetcode 53. https://leetcode.com/problems/maximum-subarray/
	// this soltn returns max subarray sum and also prints max sum subarray
	
	 public int maxSubArray(int[] nums) {
	        int csum = 0;
	        int osum = Integer.MIN_VALUE;
	        
	        int cstart = 0;
	        int cend = 0;
	        int ostart = 0;
	        int oend = 0;
	        
	        for(int i = 0; i < nums.length; i++) {
	            if(csum < 0) {
	                csum = nums[i];
	                cstart = i;
	            } else {
	                csum += nums[i];
	                cend = i;
	            }
	            if(csum > osum) {
	                osum = csum;
	                ostart = cstart;
	                oend = cend;
	            }
	        }
	        
	        for(int i = ostart; i <= oend; i++) {
	            System.out.print(nums[i] + " ");
	        }
	        
	        return osum; 
	    }
}
