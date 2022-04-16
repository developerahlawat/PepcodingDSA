package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class SquareSortedArray {
	// ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

	 // leetcode 977 https://leetcode.com/problems/squares-of-a-sorted-array/
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;
        
        for(int k = nums.length - 1; k >= 0; k--) {
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];
            if(val1 > val2) {
                res[k] = val1;
                i++;
            } else {
                res[k] = val2;
                j--;
            }
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = null;
		try {
			res = sortedSquares(nums);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
