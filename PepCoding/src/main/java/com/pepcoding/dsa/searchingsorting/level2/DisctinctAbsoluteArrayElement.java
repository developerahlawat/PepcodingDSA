package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class DisctinctAbsoluteArrayElement {
	public static int count(int[] arr) {
		int cnt = 0;

		int left = 0;
		int right = arr.length - 1;
		int prev = Integer.MIN_VALUE;
		int next = Integer.MAX_VALUE;

		while (left <= right) {
			int lval = Math.abs(arr[left]);
			int rval = Math.abs(arr[right]);

			if (lval == rval) {
				if (lval != prev && rval != next)
					cnt++;

				prev = lval;
				next = rval;
				left++;
				right--;
			} else if (lval > rval) {
				if (lval != prev)
					cnt++;

				prev = lval;
				left++;
			} else {
				// rval > lval
				if (rval != next)
					cnt++;

				next = rval;
				right--;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// input work
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(count(arr));
	}

}
