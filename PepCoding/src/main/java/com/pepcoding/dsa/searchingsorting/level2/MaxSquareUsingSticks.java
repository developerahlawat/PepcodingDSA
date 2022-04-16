package com.pepcoding.dsa.searchingsorting.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaxSquareUsingSticks {
	public static ArrayList<Integer> solve(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int ele : arr) {
			if (map.containsKey(ele) == true) {
				int nf = map.get(ele) + 1;
				map.put(ele, nf);
			} else {
				map.put(ele, 1);
			}
		}

		int max_area = 0;
		int sq = 0;

		for (int key : map.keySet()) {
			int freq = map.get(key);

			if (freq >= 4) {
				int area = key * key;

				if (area > max_area) {
					max_area = area;
					sq = freq / 4;
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		if (max_area == 0)
			ans.add(-1);
		else {
			ans.add(max_area);
			ans.add(sq);
		}
		
		return ans;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		ArrayList<Integer> ans = solve(arr);

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

}
