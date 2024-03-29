package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementRight3 {
	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int[] nge = solve(a);
		display(nge);
	}

	public static int[] solve(int[] arr) {
		int[] ans = new int[arr.length];

		Stack<Integer> st = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			
			// pop all smaller elements
			while (st.size() > 0 && st.peek() < arr[i]) {
				st.pop();
			}
			
			// update ans
			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}
			
			// push current element in the stack
			st.push(arr[i]);
		}
		return ans;
	}

}
