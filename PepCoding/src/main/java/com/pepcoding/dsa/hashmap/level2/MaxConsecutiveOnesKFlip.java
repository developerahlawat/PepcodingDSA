package com.pepcoding.dsa.hashmap.level2;

import java.util.Scanner;

public class MaxConsecutiveOnesKFlip {
	 // maximum consecutive one - II
    public static int maxConsecutive1sII(int[] arr, int k){
        int ans = 0;
        int j = -1;
        int count0 = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count0++;

            while(count0 > k) {
                // release
                j++;
                if(arr[j] == 0) count0--;
            }
            // count 0 must be less than equal to 1
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(maxConsecutive1sII(arr,k));
	}

}
