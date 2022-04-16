package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseSubstringsBtwnEachPairParentheses {
	 // leetcode 1190. https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ')') {
                st.push(ch);
            } else {
                StringBuilder str = new StringBuilder();
                while(st.peek() != '(') {
                    str.append(st.pop());
                }
                st.pop();
                for(int j = 0; j < str.length(); j++) {
                    st.push(str.charAt(j));
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while(st.size() > 0) {
            str.append(st.pop());
        }
        str.reverse();
        return str.toString();
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
