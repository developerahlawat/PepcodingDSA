package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;

public class FindPairGivenDifference {
	// difference pair with k, 
    // https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
    public boolean findPair(int arr[], int size, int n) {
        if(arr.length == 1) return false;
        //code here.
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
            
        while(j < arr.length) {
            int diff = arr[j] - arr[i];
            if(diff == n) {
                return true;
            } else if(diff > n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}