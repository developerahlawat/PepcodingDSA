package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Iterator;

public class MinimizeMaxDiffBtwnHeights {

	// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
	int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);

		int ans = arr[n - 1] - arr[0];

		int smallest = arr[0] + k;
		int largest = arr[n - 1] - k;
		int mi, ma;

		for (int i = 0; i < n - 1; i++) {
			mi = Math.min(smallest, arr[i + 1] - k);
			ma = Math.max(largest, arr[i] + k);
			if (mi < 0)
				continue;
			ans = Math.min(ans, ma - mi);
		}
		return ans;
	}
}
