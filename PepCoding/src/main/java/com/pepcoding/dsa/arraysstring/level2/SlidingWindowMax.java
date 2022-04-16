package com.pepcoding.dsa.arraysstring.level2;

import java.util.Stack;

public class SlidingWindowMax {
	private int[] nextGreaterRight(int[] arr) {
        int[] ngr = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            // pop from stack until value is available and smaller
            while(st.size() > 0 && arr[st.peek()] < arr[i]) {
                int indx = st.pop();
                ngr[indx] = i;
            }
            st.push(i);
        }

        while(st.size() > 0) {
            ngr[st.pop()] = arr.length;
        }
        return ngr;
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ngr = nextGreaterRight(arr);
        int j = 0;
        int[] res = new int[arr.length - (k - 1)];
        for(int i = 0; i < res.length; i++) {
            if(j < i) {
                j = i;
            }

            while(ngr[j] < i + k) {
                j = ngr[j];
            }
            res[i] = arr[j];
        }
        return res;
    }
}