package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Arrays;
import java.util.Scanner;

public class FindPairWithDifference {
	public static void findPair(int[] arr, int target) {
		int lo = 0;
		int hi = 1;
		Arrays.sort(arr);
		while (hi < arr.length && lo < hi) {
			int diff = arr[hi] - arr[lo];
			if (diff == target) {
				System.out.println(arr[lo] + " " + arr[hi]);
				return;
			} else if (diff > target) {
				lo++;
			} else {
				hi++;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {

		// input work
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int target = scn.nextInt();
		findPair(arr, target);
	}

}
