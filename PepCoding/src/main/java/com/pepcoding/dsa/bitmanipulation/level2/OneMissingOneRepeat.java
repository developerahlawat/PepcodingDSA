package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class OneMissingOneRepeat {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		oneRepeatOneMiss(arr);
	}

	// one number is repeating and one is missing
	public static void oneRepeatOneMiss(int[] arr) {
		int xor = 0;
		for (int val : arr) {
			xor = (xor ^ val);
		}
		for (int i = 1; i <= arr.length; i++) {
			xor = (xor ^ i);
		}

		int rsbm = (xor & (-xor));

		int x = 0;
		int y = 0;

		for (int val : arr) {
			if ((val & rsbm) == 0) {
				// bit is off
				x = (x ^ val);
			} else {
				// bit is on
				y = (y ^ val);
			}
		}
		for (int val = 1; val <= arr.length; val++) {
			if ((val & rsbm) == 0) {
				// bit is off
				x = (x ^ val);
			} else {
				// bit is on
				y = (y ^ val);
			}
		}

		// check of x is missing or y is missing
		boolean xmiss = true;
		for (int val : arr) {
			if (x == val) {
				xmiss = false;
				break;
			}
		}
		if (xmiss == true) {
			System.out.println("Missing Number -> " + x);
			System.out.println("Repeating Number -> " + y);
		} else {
			System.out.println("Missing Number -> " + y);
			System.out.println("Repeating Number -> " + x);
		}
	}
}