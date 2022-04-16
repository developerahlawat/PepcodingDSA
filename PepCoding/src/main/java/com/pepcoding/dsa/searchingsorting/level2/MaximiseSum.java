package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Arrays;
import java.util.Scanner;

public class MaximiseSum {

    public static int maximise(int[]arr) {
        long sum = 0;
        int mod = (int)(1e9) + 7;
        Arrays.sort(arr);
        for(long i = 0; i < arr.length; i++) {
            sum = sum + ((long)(arr[(int)i]) * i);
        }
        return (int)(sum % mod);
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}
