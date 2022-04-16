package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class SmallestSubarrayFreqAllMostFreqElement {
	 // smallest subarray with all the occurrence of most frequent element
    public static void printMostFreqElementArray(int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>(); // frequency map
        HashMap<Integer, Integer> imap = new HashMap<>(); // index map

        int mfreq = 0;
        int si = 0;
        int ei = 0;
        int len = 0;

        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(fmap.containsKey(val) == true) {
                // upgrade freqeuncy
                fmap.put(val, fmap.getOrDefault(val, 0) + 1);
            } else {
                // insert element with freq. 1, set starting index
                fmap.put(val, 1);
                imap.put(val, i);
            }

            if(mfreq < fmap.get(val)) {
                mfreq = fmap.get(val);
                si = imap.get(val);
                ei = i;
                len = ei - si + 1;
            } else if(mfreq == fmap.get(val)) {
                int nlen = i - imap.get(val) + 1; // new length
                if(nlen < len) {
                    si = imap.get(val);
                    ei = i;
                    len = nlen;
                }
            } else {
                // nothing to do
            }
        }
        System.out.println(arr[si]);
        System.out.println(si);
        System.out.println(ei);
    }


    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                printMostFreqElementArray(arr);
	}

}
