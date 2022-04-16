package com.pepcoding.dsa.stack.level2;

import java.util.Stack;

public class DailyTemprature {
	 // leetcode 739. https://leetcode.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            while(st.size() > 0 && temp[st.peek()] < temp[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }

        while(st.size() > 0) {
            res[st.pop()] = temp.length;
        }

        for(int i = 0; i < temp.length; i++) {
            if(res[i] == temp.length) {
                res[i] = 0;
                continue;
            }
            res[i] = res[i] - i;
        }
        return res;
    }

}
