package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubstringUniqueElement {

	 // count substrings with non repeating character
    private static int countSubStringsNonRepeating(String str) {
        int count = 0;
        int acq = -1;
        int rel = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        while(true) {
            boolean acflag = false;
            boolean reflag = false;

            while(acq < str.length() - 1) {
                acflag = true;
                acq++;
                char ch = str.charAt(acq);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.get(ch) == 2) {
                    // int n = acq - rel - 1;
                    // count += n * (n + 1) / 2;
                    break;
                } else {
                    count += acq - rel;
                }
            }


            while(rel < acq) {
                reflag = true;
                rel++;
                char ch = str.charAt(rel);

                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 1) {
                    count += acq - rel;
                    break;
                }
            }

            if(acflag == false && reflag == false) break;
        }
        return count;
    }

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(countSubStringsNonRepeating(str));
	}

}

