package com.pepcoding.dsa.hashmap.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctEveryKWindow {
	public static ArrayList<Integer> solution(int[] arr, int k) {
		// count distinct element, portal
		// add element from 0 to k-1
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int i = 0; i < k - 1; i++) {
			fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
		}

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = k - 1, j = 0; i < arr.length; i++, j++) {
			// add current element
			fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);

			// add size of fmap in result
			res.add(fmap.size());

			// reduce freq of first element of window, if freq is 0 then remove it from
			// window
			// int j = i - k + 1;

			int freq = fmap.get(arr[j]);
			if (freq == 1) {
				fmap.remove(arr[j]);
			} else {
				fmap.put(arr[j], freq - 1);
			}
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr, k);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}

}
