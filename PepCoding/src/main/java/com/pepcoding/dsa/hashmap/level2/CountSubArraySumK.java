package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArraySumK {
	// count subarray having sum is equal to K
	public static int countSumK(int[] nums, int k) {
		int psum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			psum += val;
			if (map.containsKey(psum - k) == true) {
				count += map.get(psum - k);
			}

			if (map.containsKey(psum) == false) {
				map.put(psum, 1);
			} else {
				map.put(psum, map.get(psum) + 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		System.out.println(countSumK(arr, target));
	}
}
