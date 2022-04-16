package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
	// next greater - I
	public static int[] nextGreaterElement(int[] arr, int[] query) {
		Stack<Integer> st = new Stack<>();
		// push index in stack
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				map.put(arr[st.pop()], arr[i]);
			}
			st.push(i);
		}

		int[] res = new int[query.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = map.getOrDefault(query[i], -1);
		}
		return res;
	}

	public static int[] getArr(String s) {
		String nums[] = s.split(" ");
		int n = nums.length;
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(nums[i]);
		}
		return ar;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int query[] = getArr(read.readLine());
		int nums[] = getArr(read.readLine());

		int ans[] = nextGreaterElement(nums, query);

		int n = ans.length;

		System.out.println(n);
		for (int e : ans) {
			System.out.println(e);
		}

	}
}
 