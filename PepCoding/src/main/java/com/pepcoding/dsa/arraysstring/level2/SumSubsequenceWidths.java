package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;

public class SumSubsequenceWidths {
	public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int mod = (int)1e9 + 7;
        long sum = 0;
        // make power
        int n = nums.length;
        long[] power = new long[n];
        power[0] = 1;
        for(int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        // now calculate sum
        for(int i = 0; i < n; i++) {
            sum = (sum + nums[i] * (power[i] - power[n - i - 1])) % mod;
        }
        return (int)sum; 
    }
}