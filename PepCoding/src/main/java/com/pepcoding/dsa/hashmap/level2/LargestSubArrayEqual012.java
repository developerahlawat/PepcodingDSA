package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayEqual012 {
	 // longest subarray with equal number of 0, 1 and 2
    public static int longestSubarray012(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count0++;
            } else if(arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
            String key = (count1 - count0) + "#" + (count2 - count1);
            if(map.containsKey(key) == false) {
                map.put(key, i);
            } else {
                len = Math.max(len, i - map.get(key));
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
        System.out.println(longestSubarray012(arr));
    }

}
