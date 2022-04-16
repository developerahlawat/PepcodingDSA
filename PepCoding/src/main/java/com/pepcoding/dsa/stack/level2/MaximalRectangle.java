package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximalRectangle {
	private static int[] nsrIndex(int[] arr) {
		Stack<Integer> st = new Stack<>();
		// push index in stack
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		while (st.size() > 0) {
			res[st.pop()] = arr.length;
		}
		return res;
	}

	private static int[] nslIndex(int[] arr) {
		Stack<Integer> st = new Stack<>();
		// push index in stack
		int[] res = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		while (st.size() > 0) {
			res[st.pop()] = -1;
		}
		return res;
	}

	public static int largestRectangleArea(int[] heights) {
		int[] nsr = nsrIndex(heights);
		int[] nsl = nslIndex(heights);
		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			int area = (nsr[i] - nsl[i] - 1) * heights[i];
			ans = Math.max(ans, area);
		}
		return ans;
	}

	// maximal rectangle, leetcode 85
	public static int maximalRectangle(int[][] matrix) {
		int[] ht = new int[matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					ht[j] = 0;
				} else {
					ht[j] += 1;
				}
			}
			res = Math.max(res, largestRectangleArea(ht));
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int row = Integer.parseInt(read.readLine());
		int col = Integer.parseInt(read.readLine());

		int bmat[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			String s = read.readLine();
			for (int j = 0; j < col; j++) {
				bmat[i][j] = s.charAt(j) - '0';
			}
		}

		int result = maximalRectangle(bmat);
		System.out.println(result);

	}
}
