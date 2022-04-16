package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubstringKUniqueElement {
	private static int longestKUniqueCharacter(String str, int k) {
        int ans = -1;

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
                if(map.size() < k) {
                    continue;
                } else if(map.size() == k) {
                    ans = Math.max(ans, acq - rel);
                } else {
                    break;
                }
            }

            while(rel < acq) {
                reflag = true;
                rel++;
                char ch = str.charAt(rel);
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 0) {
                    map.remove(ch);
                }

                if(map.size() > k) {
                    continue;
                } else if(map.size() == k) {
                    break;
                }
            }

            if(acflag == false && reflag == false) break;
        }
        return ans;
    }

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(longestKUniqueCharacter(str,k));
	}

}
