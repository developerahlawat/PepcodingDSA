package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinAddToMakeParenthesesValid {
	// leetcode 921.
	public static int minAddToMakeValid(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || st.size() == 0) {
				st.push(ch);
			} else if (st.peek() == '(') {
				st.pop();
			} else {
				st.push(ch);
			}
		}
		return st.size();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int result = minAddToMakeValid(read.readLine());
		System.out.println(result);
	}
}