package com.pepcoding.dsa.stackandqueue.level1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets2 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(isBalanced(str));
	}

	public static boolean isBalanced(String str) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if(st.size()==0)
					return false;//more closing brackets
				else if (ch == ')') {
					if (st.peek() != '(')
						return false;
				} else if (ch == '}') {
					if (st.peek() != '{')
						return false;
				} else if (ch == ']') {
					if (st.peek() != '[')
						return false;
				}
				st.pop();
			}

		}
		if (st.size() == 0) {
			return true;
		} else {
			//more opening brackets
			return false;
		}
	}

}
