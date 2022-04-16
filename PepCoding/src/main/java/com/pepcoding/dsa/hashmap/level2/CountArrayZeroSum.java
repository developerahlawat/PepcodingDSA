package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountArrayZeroSum {
	// Number of Subarray having sum is equal to 0
    public static int solution(int[] arr) {
		int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int psum = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            psum += val;
            if(map.containsKey(psum) == false) {
                map.put(psum, 1);
            } else {
                int ofq = map.get(psum);
                count += ofq;
                map.put(psum, ofq + 1);
            }
        }
        
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}
}
