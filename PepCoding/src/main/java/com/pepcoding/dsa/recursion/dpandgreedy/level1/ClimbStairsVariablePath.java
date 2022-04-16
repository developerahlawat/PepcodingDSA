package com.pepcoding.dsa.recursion.dpandgreedy.level1;

import java.util.Scanner;

public class ClimbStairsVariablePath {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] dp = new int[n + 1];

		System.out.println(csVarTab(arr));
		System.out.println(csVarDp(arr, 0, dp));
		System.out.println(csVarRec(arr, 0));
	}

	public static int csVarTab(int[] arr) {
		int[] dp = new int[arr.length + 1];

		dp[dp.length - 1] = 1;

		for (int i = dp.length - 2; i >= 0; i--) {
			int ans = 0;
			for (int jump = 1; jump <= arr[i]; jump++)
				if(i+jump<dp.length)
				 ans += dp[i + jump];
			dp[i] = ans;
		}

		return dp[0];
	}

	public static int csVarDp(int[] arr, int idx, int[] dp) {
		if (idx == arr.length)
			return 1;

		if (idx > arr.length)
			return 0;

		if (dp[idx] != 0)
			return dp[idx];

		int ans = 0;
		for (int jump = 1; jump <= arr[idx]; jump++)
			ans += csVarRec(arr, idx + jump);

		dp[idx] = ans;

		return ans;
	}

	public static int csVarRec(int[] arr, int idx) {
		if (idx == arr.length)
			return 1;

		if (idx > arr.length)
			return 0;

		int ans = 0;
		for (int jump = 1; jump <= arr[idx]; jump++)
			ans += csVarRec(arr, idx + jump);

		return ans;
	}

}
