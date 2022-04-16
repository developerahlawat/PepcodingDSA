package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinRemovalValidParentheses {
	public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(i);
            } else if(ch == ')') {
                if(st.size() == 0 || s.charAt(st.peek()) == ')') {
                    st.push(i);
                } else {
                    // stack peek is equal to opening bracket
                    st.pop();
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(st.size()>0 && st.peek() == i) {
                st.pop();
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
   
}
}