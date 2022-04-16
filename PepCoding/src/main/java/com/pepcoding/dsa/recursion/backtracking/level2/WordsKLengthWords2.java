package com.pepcoding.dsa.recursion.backtracking.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WordsKLengthWords2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}
		combination(1, k, ustr, new HashSet<>(), "");
	}

	public static void combination(int cs, int ts, String ustr, HashSet<Character> used, String asf) {
		if (cs > ts) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			if (used.contains(ch) == false) {
				used.add(ch);
				combination(cs + 1, ts, ustr, used, asf + ch);
				used.remove(ch);
			}
		}
	}
}
