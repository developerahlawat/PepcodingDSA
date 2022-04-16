package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArraySumDivK {
	 // count of subarray with sum divisible by k
    public static int CountSumDivisibleByK(int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            sum += val;
            int rem = sum % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem) == false) {
                map.put(rem, 1);
            } else {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(CountSumDivisibleByK(arr, k));
    }
}
