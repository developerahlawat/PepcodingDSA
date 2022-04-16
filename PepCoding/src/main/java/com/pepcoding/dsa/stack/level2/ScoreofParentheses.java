package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ScoreofParentheses {
	  // leetcode 856. https://leetcode.com/problems/score-of-parentheses/
    public static int scoreOfParentheses(String s) {
        // marker -> -1 means opening bracket, and number is score of parenthesis, ()-> 1, (A) -> 2*A, AB -> A+B
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(-1);
            } else if(st.peek() == -1){
                st.pop();
                st.push(1);
            } else {
                int sum = 0;
                while(st.peek() != -1) {
                    sum += st.pop();
                }
                st.pop();
                st.push(2 * sum);
            }
        }
        int add=0;
        while(st.size()>0)
            add+=st.pop();
        return add;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}
