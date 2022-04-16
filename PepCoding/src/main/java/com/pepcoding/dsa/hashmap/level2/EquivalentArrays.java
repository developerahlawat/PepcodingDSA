package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EquivalentArrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
		int res=countEquivalentSubArray(arr);
		
		System.out.println(res);
		
	}
	
	 // count equivalent subarray
    public static int countEquivalentSubArray(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr) {
            set.add(val);
        }
        int k = set.size();

        // solve, number of subarrays having k distinct elements, [imp : K is distinct element in whole array]
        int acq = -1;
        int rel = -1;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(true) {
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire
            while(acq < n - 1 ) {
                flag1 = true;
                acq++;
                int val = arr[acq];
                map.put(val, map.getOrDefault(val, 0) + 1);
                if(map.size() == k) {
                    count += n - acq;
                    break;
                }
            }
            // release
            while(rel < acq) {
                flag2 = true;
                rel++;
                int val = arr[rel];
                map.put(val, map.get(val) - 1);
                if(map.get(val) == 0) {
                    map.remove(val);
                }

                if(map.size() == k) {
                    count += n - acq;
                } else {
                    break;
                }
            }
            if(flag1 == false && flag2 == false) {
                break;
            }
        }
        return count;
    }




}
