package com.pepcoding.dsa.hashmap.level2;

import java.util.HashSet;
import java.util.Scanner;

public class CheckArithmaticSequence {
	  // check arithmetic Sequ
    public static boolean checkArithMaticSeq(int[] arr) {
        // find min and max and add element in hashset 
        if(arr.length <= 1) return true; 
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            set.add(val);
        }

        int n = arr.length;
        int d = (max - min) / (n - 1);
        int sum = min;
        while(sum < max) {
            sum += d;
            if(set.contains(sum) == false) return false;
        }
        return true;
    }

    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(checkArithMaticSeq(arr));
	}

}
