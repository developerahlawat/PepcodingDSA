package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TrappingRainWater {
	// leetcode 42. trapping rain water, https://leetcode.com/problems/trapping-rain-water/
    // method 1. using array, left max and rightmax, think about head of building

    // method 2. Using Stack
    public static int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int water = 0;
        for(int i = 0; i < height.length; i++) {
            int val = height[i];
            int rmax = val; // right max
            int rindx = i; // right index
            while(st.size() > 0 && height[st.peek()] < val) {
                int cht = height[st.pop()];
                if(st.size() == 0) break;
                int lmaxIndx = st.peek();
                int lmax = height[lmaxIndx];
                water += (Math.min(lmax, rmax) - cht) * (rindx - lmaxIndx - 1);
            }
            st.push(i);
        }
        return water;
    }

    // method 3. Two Pointer Approach
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int lmax = 0;
        int rmax = 0;

        int water = 0;
        while(left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if(lmax < rmax) {
                water += lmax - height[left];
                left++;
            } else {
                water += rmax - height[right];
                right--;
            }
        }
        return water;
    }

    // method 4. using dual iteration
    public int trap4(int[] height) {
        int owater = 0; // overall water
        int maxIndx = 0;
        int rwater = 0; // runnning water
        for(int i = 0; i < height.length; i++) {
            if(height[maxIndx] <= height[i]) {
                owater += rwater;
                rwater = 0;
                maxIndx = i;
            }
            rwater += height[maxIndx] - height[i];
        }
        rwater = 0;
        int rmaxIndx = height.length - 1;
        // some amount of water is not safe
        for(int i = height.length - 1; i >= maxIndx; i--) {
            if(height[rmaxIndx] <= height[i]) {
                owater += rwater;
                rwater = 0;
                rmaxIndx = i;
            }
            rwater += height[rmaxIndx] - height[i];
        }
        return owater;
    }



    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = Integer.parseInt(read.readLine());
        int result = trap(arr);
        System.out.println(result);
        
    }
}