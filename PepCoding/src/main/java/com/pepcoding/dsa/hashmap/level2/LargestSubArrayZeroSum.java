package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayZeroSum {
	
	// largest subarray with 0 sum
	    public static int solution(int[] arr) {
			int psum = 0;
	        HashMap<Integer, Integer> map = new HashMap<>();
	        int len = 0;
	        map.put(0, -1);
	        for(int i = 0; i < arr.length; i++) {
	            int val = arr[i];
	            psum += val;
	            if(map.containsKey(psum) == false) {
	                map.put(psum, i);
	            } else {
	                len = Math.max(len, i - map.get(psum));
	            }
	        }
			return len;
		}

		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}

	}
