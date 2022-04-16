package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArraySumK {
	 // This is a functional problem. You have to complete this function.
    // It takes as input an array and K.
    // It should return the length of maximum subarray whose sum is K. If no such subarray, return 0.
    // longest length of subarray having sum equal to K
   public static int maxLenSubarray(int[] nums, int k) {
       int psum = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
       int len = 0;
       for(int i = 0; i < nums.length; i++) {
           int val = nums[i];
           psum += val;
           if(map.containsKey(psum - k) == true) {
               len = Math.max(len, i - map.get(psum - k));
           }

           if(map.containsKey(psum) == false) {
               map.put(psum, i);
           }
       }
       return len;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int result = maxLenSubarray(arr1, K);

        System.out.println(result);

    }

    // Function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    } 
}
