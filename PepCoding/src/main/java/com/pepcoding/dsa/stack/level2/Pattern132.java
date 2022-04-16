package com.pepcoding.dsa.stack.level2;

import java.util.Stack;

public class Pattern132 {
	 // leetcode 456, https://leetcode.com/problems/132-pattern/
    public boolean find132pattern(int[] nums) {
        // prepare left min
        int[] lmin = new int[nums.length];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            lmin[i] = min;
        }
        
        Stack<Integer> st = new Stack<>();
        // find pattern
        for(int i = nums.length - 1; i >= 0; i--) {
            // pop while we can
            while(st.size() > 0 && st.peek() <= lmin[i]) {
                st.pop();
            }
            // check for result
            if(st.size() > 0 && st.peek() < nums[i]) {
                return true;
            }
            // push in stack
            st.push(nums[i]);
        }
        return false;
    }

}
