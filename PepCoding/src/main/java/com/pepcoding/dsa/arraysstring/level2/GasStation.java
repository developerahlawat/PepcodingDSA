package com.pepcoding.dsa.arraysstring.level2;

public class GasStation {
	 // leetcode 134. https://leetcode.com/problems/gas-station/
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasSum = 0;
		int costSum = 0;
		for (int i = 0; i < gas.length; i++) {
			gasSum += gas[i];
			costSum += cost[i];
		}
		if (gasSum - costSum < 0) {
			return -1;
		}
		int indx = 0;
		int prefixSum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < gas.length; i++) {
			prefixSum += gas[i] - cost[i];
			if (prefixSum < min) {
				min = prefixSum;
				indx = i;
			}
		}
		return (indx + 1) % gas.length;
	}
}