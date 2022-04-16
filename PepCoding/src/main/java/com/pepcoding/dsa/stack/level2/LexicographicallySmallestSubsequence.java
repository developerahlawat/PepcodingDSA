package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LexicographicallySmallestSubsequence {
	// Lexicographically Smallest Subsequence, portal
	public static int[] smallest(int[] num, int k) {
		// use linkedlist as stack
		LinkedList<Integer> st = new LinkedList<>();
		k = num.length - k;
		for (int i = 0; i < num.length; i++) {
			int ch = num[i];
			while (k > 0 && st.size() > 0 && st.getLast() > ch) {
				k--;
				st.removeLast();
			}
			st.addLast(ch);
		}
		// manage remaining K's
		while (k > 0) {
			st.removeLast();
			k--;
		}
		int[] res = new int[st.size()];
		int i = 0;
		for (int ch : st) {
			res[i] = ch;
			i++;
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(read.readLine());
		int k = Integer.parseInt(read.readLine());
		int ans[] = smallest(arr, k);
		System.out.println(ans.length);

		for (int e : ans) {
			System.out.println(e);
		}

	}

}
