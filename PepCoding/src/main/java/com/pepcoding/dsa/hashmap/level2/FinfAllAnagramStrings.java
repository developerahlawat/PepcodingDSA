package com.pepcoding.dsa.hashmap.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FinfAllAnagramStrings {
	// find all anagrams in a string
    private static boolean match(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for(Character key : map1.keySet()) {
            int val1 = map1.getOrDefault(key, -1);
            int val2 = map2.getOrDefault(key, -1);
            if(val1 != val2) return false;
        }
        return true;
    }

    public static void findAnagrams(String s, String p) {
        HashMap<Character, Integer> pmap = new HashMap<>(); // pattern map
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> smap = new HashMap<>(); // source map
        // acquire first window of length =  p.length
        for(int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = p.length(); i < s.length(); i++) {
            // match
            if(match(smap, pmap) == true) {
                res.add(i - p.length());
            }

            // we can use equals function too
            // if(smap.equals(pmap) == true) {
            // }

            // acquire
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            // release
            char relCh = s.charAt(i - p.length()); // relCh - > releasing character
            smap.put(relCh, smap.get(relCh) - 1);
            if(smap.get(relCh) == 0) smap.remove(relCh);
        }
        if(match(smap, pmap) == true) {
            res.add(s.length() - 1 - p.length());
        }
        System.out.println(res.size());
        for(int val : res) System.out.print(val + " ");
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}
