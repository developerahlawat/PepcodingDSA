package com.pepcoding.dsa.searchingsorting.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountXorPairs {
	public static int countPairs(int[]arr) {
		 HashMap<Integer, Integer> map = new HashMap<>();

	        for(int val : arr) {
	            int fq = map.containsKey(val) == true ? map.get(val) : 0;
	            map.put(val, fq + 1);
	        }

	        int pairs = 0;
	        for(int val : map.keySet()) {
	            int freq = map.get(val);
	            pairs += (freq) * (freq - 1) / 2;
	        }
	        return pairs;
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[]arr = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    System.out.println(countPairs(arr));
	  }
	}

