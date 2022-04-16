package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementOnLeft {
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

		int[] ngl = ngl(a);
		display(ngl);
	}

	// ngl -> next greater on left
	private static int[] ngl(int[] arr) {
		Stack<Integer> st = new Stack<>();
		// push index in stack
		int[] res = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}
		while (st.size() > 0) {
			res[st.pop()] = -1;
		}
		return res;
	}

}
