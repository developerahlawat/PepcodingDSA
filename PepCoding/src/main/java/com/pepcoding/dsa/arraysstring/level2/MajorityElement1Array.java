package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class MajorityElement1Array {

	// ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
// leetcode 169 https://leetcode.com/problems/majority-element/
	public static int majorityElement(int[] nums) {// mooree algo
		int val = nums[0];
		int count = 1;

		int i = 1;
		while (i < nums.length) {
			if (val == nums[i]) {
				// increase the count of same element
				count++;
			} else
				// pair distinct pair
				count--;
			if (count == 0) {
				val = nums[i];
				count = 1;
			}

			i++;
		}
		// majority always exist, so val is result
		return val;
	}

	public static void printMajorityElement(int[] arr) {
		int maj = majorityElement(arr);// get majority from moore's algo
		int count = 0;
		for (int val : arr) {
			if (val == maj)
				count++;
		}
		if (count > arr.length / 2)
			System.out.println(maj);
		else
			System.out.println("No Majority Element exist");
	}

	// ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		printMajorityElement(arr);
	}
}
