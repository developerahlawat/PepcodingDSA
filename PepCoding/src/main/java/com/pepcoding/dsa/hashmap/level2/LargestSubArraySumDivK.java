package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArraySumDivK {
	// longest subarray having sum divisible by k
    public static int longestSumDivisibleByK(int[] arr, int k) {
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            sum += val;
            int rem = sum % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem) == false) {
                map.put(rem, i);
            } else {
                len = Math.max(len, i - map.get(rem));
            }
        }
        return len;
    } 
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(longestSumDivisibleByK(arr, k));
    }

}
