package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class MajorityElement2Array {
	// ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
	// // leetcode 229 https://leetcode.com/problems/majority-element-ii/
		public static ArrayList<Integer> majorityElement2(int[] nums) {// mooree algo
			int val1 = nums[0];
			int count1 = 1;
			int val2 = nums[0];
			int count2 = 0;
			
			
			int i = 1;
			while (i < nums.length) {
				if (val1 == nums[i]) {
					// increase the count of same element
					count1++;
				}
				else if (val2 == nums[i]) {
					// increase the count of same element
					count2++;
				}else{ 
				if (count1 == 0) {
					val1 = nums[i];
					count1 = 1;
				}
				else if (count2 == 0) {
					val2 = nums[i];
					count2 = 1;
				}else{
					// pair distinct pair
					count1--;
				    count2--;
				}
				}

				i++;
			}
			// majority always exist, so val is result
			ArrayList<Integer>res=new ArrayList<>();
			
			boolean check1=checkFreqM2(nums,val1);
			if(count1>0 && check1==true) res.add(val1);
			  if(val1 == val2) return res;
			boolean check2=checkFreqM2(nums,val2);
			if(count2>0 && check2==true) res.add(val2);
			
			return res;
		}

		private static boolean checkFreqM2  (int[] arr, int val) {
		int count = 0;
		for (int e : arr) {
			if (e == val)
				count++;
		}
		return count>arr.length/3;
	}


		// ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			ArrayList<Integer> res = majorityElement2(arr);
	        System.out.println(res);
		}
}
