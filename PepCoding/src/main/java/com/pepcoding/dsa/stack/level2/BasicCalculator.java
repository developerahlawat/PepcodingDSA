package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BasicCalculator {
	// basic calculator 224, https://leetcode.com/problems/basic-calculator/
    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                continue;
            } else if(ch >= '0' && ch <= '9') {
                // number may have more than one digit
                long n = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    n *= 10;
                    n += (int)(s.charAt(i) - '0');
                    i++;
                }
                i--;
                n *= sign;
                sum += (int)n;
                sign = 1;
            } else if(ch == '(') {
                st.push(sum);
                st.push(sign);
                sign = 1;
                sum = 0;
            } else if(ch == ')') {
                sum *= st.pop(); // multiply sign from sum
                sum += st.pop(); // add old sum in new one
            } else if(ch == '-') {
                sign *= -1;
            } else {
                // ch is +ve
                // nothing to do
            }
        }
        return sum;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);
        
    }
}
