package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordPattern {
	 // word pattern
    public static boolean wordPattern(String pattern, String strs) {
        String[] str = strs.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++) {
            char ch1 = pattern.charAt(i);
            String ch2 = str[i];

            if(map.containsKey(ch1) == true) {
                if(map.get(ch1).equals(ch2) == false) return false;
            } else {
                if(set.contains(ch2) == true) {
                    return false;
                } else {
                    map.put(ch1, ch2);
                    set.add(ch2);
                }
            }
        }
        return true;
	}

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}
