package com.pepcoding.dsa.stack.level2;

import java.util.Stack;

public class MinReversalExpressionBalanced {
	// count reversal
	// https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
	private int countRev(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{' || st.size() == 0) {
				st.push(ch);
			} else if (st.peek() == '}') {
				st.pop();
			} else {
				st.push(ch);
			}
		}
		int op = 0;
		int cl = 0;
		while (st.size() > 0) {
			char ch = st.pop();
			if (ch == '{') {
				op++;
			} else {
				cl++;
			}
		}

		return (int) (Math.ceil(op / 2.0) + Math.ceil(cl / 2.0));
	}
}
