package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubstringAtMostKUniqueElement {
	// count of substring with at most k unique characters
    private static int countOfSubStringAtMostK(String str, int k) {
        int count = 0;
        int acq = -1;
        int rel = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while(acq < str.length() - 1) {
                flag1 = true;
                acq++;
                char ch = str.charAt(acq);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.size() <= k) {
                    count += acq - rel;
                } else {
                    break;
                }
            }
            if(acq == str.length() - 1 && map.size() <= k) {
                break;
            }
            while(rel < acq) {
                flag2 = true;
                rel++;
                char ch = str.charAt(rel);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);
                if(map.size() == k) {
                    count += acq - rel;
                    break;
                }
            }
            if(flag1 == false && flag2 == false) break;
        }
        return count;
    }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(countOfSubStringAtMostK(str,k));
	}

}
