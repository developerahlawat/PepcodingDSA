package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class PairSumDivK {
	// Check If An Array Can Be Divided Into Pairs Whose Sum Is Divisible By K,
	// portal
	public static void solution(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// prepare freq map of remainders
		for (int val : arr) {
			int rem = val % k;
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int rem : map.keySet()) {
			if (rem == 0) {
				if (map.get(rem) % 2 == 1) {
					System.out.println(false);
					return;
				}
			} else if (rem * 2 == k) {
				if (map.get(rem) % 2 == 1) {
					System.out.println(false);
					return;
				}
			} else {
				if (map.get(k - rem) != map.get(rem)) {
					System.out.println(false);
					return;
				}
			}
		}
		System.out.println(true);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr, k);
	}

}
