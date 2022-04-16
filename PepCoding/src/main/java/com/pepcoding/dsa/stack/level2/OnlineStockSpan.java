package com.pepcoding.dsa.stack.level2;

import java.util.Stack;

public class OnlineStockSpan {
	 //leet code 901 https://leetcode.com/problems/online-stock-span/
    class StockSpanner {
        private class Pair {
            int val;
            int indx;
            Pair(int val, int indx) {
                this.val = val;
                this.indx = indx;
            }
        }

        private int indx;
        private Stack<Pair> st;
        
        public StockSpanner() {
            st = new Stack<>();
            indx = -1;
            st.push(new Pair(Integer.MAX_VALUE, indx));
            indx++;
        }
        
        public int next(int price) {
            while(st.size() > 0 && st.peek().val <= price) {
                st.pop();
            }
            int span = indx - st.peek().indx;
            st.push(new Pair(price, indx));
            indx++;
            return span;
        }
    }

}
