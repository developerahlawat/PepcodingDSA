package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class FindPivotIndex {
	public static int pivot_index(int[] nums) {
		int tsum = 0;
		for (int val : nums)
			tsum += val;

		int lsum = 0;
		for (int i = 0; i < nums.length; i++) {
			tsum -= nums[i];
			if (lsum == tsum) {
				return i;
			}
			lsum += nums[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// input work
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int pi = pivot_index(arr);
		System.out.println(pi);
	}
}
