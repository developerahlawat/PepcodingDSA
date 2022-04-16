package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class NoOfValidWords {
	 // no. of valid words
    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		// map of char vs bit mask of word
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            map.put(ch, new ArrayList<>());
        }

        for(String word : words) {
            HashSet<Character> set = new HashSet<>();
            // prepare mask for word
            int mask = 0;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int k = (int)(ch - 'a');
                mask = (mask | (1 << k));
            }

            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(set.contains(ch)) continue;
                set.add(ch);
                map.get(ch).add(mask);
            }
        }
        
        // prepare count
        ArrayList<Integer> counts = new ArrayList<>();
        for(String puzzle : puzzles) {
            // prepare mask of puzzle
            int mask = 0;
            for(int i = 0; i < puzzle.length(); i++) {
                char ch = puzzle.charAt(i);
                int k = (int)(ch - 'a');
                mask = (mask | (1 << k));
            }

            // check in valid word and find count
            char firstChar = puzzle.charAt(0);
            int count = 0;
            for(int wordMask : map.get(firstChar)) {
                if((wordMask & mask) == wordMask) {
                    count++;
                }
            }
            counts.add(count);
        }
        return counts;
	}

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int m = scn.nextInt();
    String[] puzzles = new String[m];
    for (int i = 0 ; i < m ; i++) {
      puzzles[i] = scn.next();
    }
    ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
    for (int i = 0 ; i < m ; i++) {
      System.out.println(puzzles[i] + " -> " + ans.get(i));
    }
  }


}
