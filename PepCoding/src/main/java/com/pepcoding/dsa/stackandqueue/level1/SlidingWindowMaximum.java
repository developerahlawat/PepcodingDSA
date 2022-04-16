package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());

		//usingStack(arr, k);

		usingDeque(arr, k);
	}

	private static void usingDeque(int[] arr, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (dq.size() > 0 && arr[dq.getFirst()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.println(arr[dq.getFirst()]);

		for(int i=k;i<arr.length;i++) {
			while(dq.size()>0 && arr[dq.getFirst()]<arr[i])
	              dq.removeLast();
			
			dq.addLast(i);
			
			if(dq.getFirst()<=i-k)
				dq.removeFirst();
			
			System.out.println(arr[dq.getFirst()]);
		}
	}

	private static void usingStack(int[] a, int k) {
		int[] ngr = new int[a.length];
		Stack<Integer> st = new Stack<>();

		for (int i = a.length - 1; i >= 0; i--) {
			// pop all smaller elements
			while (st.size() > 0 && a[st.peek()] < a[i])
				st.pop();

			// update ur ans
			if (st.size() == 0)
				ngr[i] = a.length;
			else
				ngr[i] = st.peek();

			// p=ush current index
			st.push(i);
		}

		for (int i = 0, j = 0; i <= a.length - k; i++) {
			if (j < i)
				j = i;

			while (ngr[j] < i + k)
				j = ngr[j];

			System.out.println(a[j]);
		}
	}

}
