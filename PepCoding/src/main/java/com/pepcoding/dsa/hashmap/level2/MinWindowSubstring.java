package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class MinWindowSubstring {

public static String smallestSubStringAllChar(String s1, String s2){
        // frequency map for string 2
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        
        // move toward solution
        int acq = -1; // acquire
        int rel = -1; // release
        int count = 0;
        int requirement = s2.length();
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        while(true) {
            boolean acFlag = false; // acquire flag
            boolean reFlag = false; // release flag
            // acquire
            while(acq < s1.length() - 1 && count < requirement) {
                acq++;
                char ch = s1.charAt(acq);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // conditional increment in count
                if(map.get(ch) <= fmap.getOrDefault(ch, 0)) {
                    count++;
                }
                acFlag = true;
            }
        
            // release
            while(count == requirement) {
                // hold ans, and if smallest then update the result
                String tempAns = s1.substring(rel + 1, acq + 1);
                if(ans.length() == 0 || tempAns.length() < ans.length()) {
                    ans = tempAns;
                }
                // get the character and remove from map(either dec. freq. or remove key from map)
                rel++;
                char ch = s1.charAt(rel);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);

                // decrement in count if release is invalid
                if(map.getOrDefault(ch, 0) < fmap.getOrDefault(ch, 0)) {
                    count--;
                }
                reFlag = true;    
            }
            
            // conditional break from loop
            if(acFlag == false && reFlag == false) {
                break;
            }
        }
        return ans;
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(smallestSubStringAllChar(s1,s2));
	}

}
