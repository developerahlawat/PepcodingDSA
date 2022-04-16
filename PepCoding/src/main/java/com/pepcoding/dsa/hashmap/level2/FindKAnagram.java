package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class FindKAnagram {
	  // k anagram
    public static boolean areKAnagrams(String s1, String s2, int k) {
		if(s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        // freq. map for s1
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // reduce mapping from s2
        for(int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if(map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }
        // add +ve count
        int count = 0;
        for(char ch : map.keySet()) {
            count += map.get(ch);
        }
        return count <= k;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
