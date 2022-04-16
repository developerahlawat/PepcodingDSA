package com.pepcoding.dsa.arraysstring.level2;

public class CarPooling {
	   // leetcode 1094. https://leetcode.com/problems/car-pooling/
	 public boolean carPooling(int[][] trips, int capacity) {
	        int len = 0;
	        // rows -> no. of trips
	        // column[0] -> number of passenger
	        // column[1] -> starting of trip
	        // column[2] -> ending of trip

	        int[] arr = new int[1001];

	        // travel on query and mark impact on array
	        for(int i = 0; i < trips.length; i++) {
	            int start = trips[i][1];
	            int end = trips[i][2];
	            int pass = trips[i][0];
	            arr[start] += pass;
	            arr[end] -= pass;

	            len = Math.max(len, end);
	        }

	        // make prefix sum to create impact of passenger's count
	        int prefixSum = 0;
	        for(int i = 0; i <= len; i++) {
	            prefixSum += arr[i];
	            arr[i] = prefixSum;

	            if(arr[i] > capacity) return false;
	        }
	        return true;
	    }
	}
