package com.pepcoding.dsa.hashmap.level2;

import java.util.HashSet;
import java.util.Scanner;

public class PairsWithEqualSum {
	 // pair with equal sum
    public static boolean pairWithEqualSum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(set.contains(sum) == true) {
                    return true;
                } else {
                    set.add(sum);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(pairWithEqualSum(arr));
    }

}
