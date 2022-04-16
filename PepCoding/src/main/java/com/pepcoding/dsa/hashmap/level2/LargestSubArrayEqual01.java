package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayEqual01 {
	public static int longest01SubArray(int[] arr) {
        // step 1 : change 0 to -1
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }
        // step 2 : solve for longest subarray having sum equal to 0
        return solution(arr);
    }


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
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(longest01SubArray(arr));
    }


}
