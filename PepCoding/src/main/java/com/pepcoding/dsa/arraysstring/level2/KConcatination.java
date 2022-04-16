package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class KConcatination {
	
	// k concatenation, codechef
	//https://leetcode.com/problems/k-concatenation-maximum-sum/submissions/  --this one has few more test cases.
	public static long kadanes(int[] nums) {
		long csum = 0;
		long osum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (csum < 0) {
				csum = nums[i];
			} else {
				csum += nums[i];
			}
			if (csum > osum) {
				osum = csum;
			}
		}
		return osum;
	}

	private static long kadanes1_2(int[] arr) {
		int n = arr.length;
		int[] narr = new int[2 * n];

		for (int i = 0; i < n; i++) {
			narr[i] = arr[i];
			narr[n + i] = arr[i];
		}
		return kadanes(narr);
	}

	public static long solution(int[] arr, int k, long sum) {
		if (k == 1) {
			return kadanes(arr);
		}
		long kadane12 = kadanes1_2(arr);
		if (sum < 0) {
			return kadane12;
		} else {
			return kadane12 + (sum * (k - 2));
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		System.out.println(solution(arr, k, sum));
	}

}