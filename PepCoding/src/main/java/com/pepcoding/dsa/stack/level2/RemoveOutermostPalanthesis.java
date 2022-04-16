package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveOutermostPalanthesis {
	// leetcode 1021, https://leetcode.com/problems/remove-outermost-parentheses/
    public static String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        
        int op = 0;
        int cl = 0;
        int si = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                op++;
            } else {
                cl++;
            }

            if(op == cl) {
                for(int j = si + 1; j < i; j++) {
                    str.append(s.charAt(j));
                }
                op = 0;
                cl = 0;
                si = i + 1;
            }
        }

        return str.toString();
    }


  public static  void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String result = removeOuterParentheses(read.readLine());
    System.out.println(result);
  }

}
