package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
	// ngr -> next greater on right
	private static int[] nextGreaterElementII(int[] arr) {
		Stack<Integer> st = new Stack<>();
		// push index in stack
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);
		for (int i = 0; i < 2 * arr.length; i++) {
			int indx = i % arr.length;
			while (st.size() > 0 && arr[st.peek()] < arr[indx]) {
				res[st.pop()] = arr[indx];
			}
			st.push(indx);
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(read.readLine());
		}

		int ans[] = nextGreaterElementII(nums);

		n = ans.length;

		System.out.println(n);
		for (int e : ans) {
			System.out.println(e);
		}

	}
}