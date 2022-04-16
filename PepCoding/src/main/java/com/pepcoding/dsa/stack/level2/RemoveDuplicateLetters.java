package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
	// leetcode 316, https://leetcode.com/problems/remove-duplicate-letters/
	public static String removeDuplicateLetters(String s) {
		HashMap<Character, Integer> fmap = new HashMap<>(); // frequency map
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int of = fmap.getOrDefault(ch, 0);
			fmap.put(ch, of + 1);
		}

		HashMap<Character, Boolean> pmap = new HashMap<>(); // presence map
		LinkedList<Character> st = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int fq = fmap.get(ch);
			fmap.put(ch, fq - 1);

			if (pmap.containsKey(ch) == true && pmap.get(ch) == true)
				continue;

			while (st.size() > 0 && st.getLast() > ch && fmap.get(st.getLast()) > 0) {
				char rch = st.removeLast(); // rch-> remove character
				pmap.put(rch, false);
			}
			st.addLast(ch);
			pmap.put(ch, true);
		}

		StringBuilder str = new StringBuilder();
		for (char ch : st) {
			str.append(ch);
		}
		return str.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		String result = removeDuplicateLetters(read.readLine());
		System.out.println(result);

	}
}
