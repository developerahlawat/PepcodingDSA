package com.pepcoding.dsa.stack.level2;

import java.util.LinkedList;

public class RemoveKDigits {
    // leetcode 402, https://leetcode.com/problems/remove-k-digits/
    public String removeKdigits(String num, int k) {
        // use linkedlist as stack
        LinkedList<Character> st = new LinkedList<>();
        
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while(k > 0 && st.size() > 0 && st.getLast() > ch) {
                k--;
                st.removeLast();
            }
            st.addLast(ch);
        }
        
        // manage remaining K's
        while(k > 0) {
            st.removeLast();
            k--;
        }
        
        // manage leading 0's
        while(st.size() > 0 && st.getFirst() == '0') {
            st.removeFirst();
        }
        
        StringBuilder str = new StringBuilder();
        for(char ch : st) {
            str.append(ch);
        }
        return str.length() == 0 ? "0" : str.toString();
    }

}
