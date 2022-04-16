package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class SortArrayByParity {
  // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    
    // leetcode 905. https://leetcode.com/problems/sort-array-by-parity/
    public static void sortArrayByParity(int[] nums) {
        int i = 0; // first unsolved
        int j = 0; // first odd

        while(i < nums.length) {
            if(nums[i] % 2 == 0) {
                // even
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            } else {
                // odd
                i++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}