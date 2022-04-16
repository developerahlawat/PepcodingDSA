package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MinWindowSubstringUniqueElement {

	// smallest substring of a string containing all unique character of itself
	private static int smallestSubStringAllUniqueChar(String str) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}

		int acq = -1;
		int rel = -1;
		int ansLen = Integer.MAX_VALUE;
		HashMap<Character, Integer> map = new HashMap<>();
		while (true) {
			boolean acflag = false;
			boolean reflag = false;
			// acquire
			while (acq < str.length() - 1 && map.size() < set.size()) {
				acq++;
				char ch = str.charAt(acq);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				acflag = true;
			}
			// release
			while (map.size() == set.size()) {
				int tempLen = acq - rel;
				if (tempLen < ansLen) {
					ansLen = tempLen;
				}

				rel++;
				char ch = str.charAt(rel);
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					map.remove(ch);

				reflag = true;
			}

			if (acflag == false && reflag == false)
				break;
		}
		return ansLen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(smallestSubStringAllUniqueChar(str));
	}

}
