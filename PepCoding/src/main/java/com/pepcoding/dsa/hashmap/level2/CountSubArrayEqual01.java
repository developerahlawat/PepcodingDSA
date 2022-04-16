package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArrayEqual01 {
	public static int count01SubArray(int[] arr) {
		// step 1 : change 0 to -1
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		// step 2 : solve for count subarray having sum equal to 0
		return countSubArray1(arr);
	}

	// Number of Subarray having sum is equal to 0
	public static int countSubArray1(int[] arr) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int psum = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			psum += val;
			if (map.containsKey(psum) == false) {
				map.put(psum, 1);
			} else {
				int ofq = map.get(psum);
				count += ofq;
				map.put(psum, ofq + 1);
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
		System.out.println(count01SubArray(arr));
	}

}
