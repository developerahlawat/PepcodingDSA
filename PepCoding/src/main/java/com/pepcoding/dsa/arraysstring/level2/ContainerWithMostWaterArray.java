package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class ContainerWithMostWaterArray {
	// ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
	 // leetcode 11 https://leetcode.com/problems/container-with-most-water/
    public static int mostWater(int[] height) {
        int maxWater = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            int l = j - i;
            int h = Math.min(height[i], height[j]);
            int water = l * h;
            maxWater = Math.max(maxWater, water);

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}
