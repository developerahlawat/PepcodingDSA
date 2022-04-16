package com.pepcoding.dsa.recursion.backtracking.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class WordsKLengthWords1 {

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
		Character[] spots = new Character[k];
		combination(0, ustr, 0, k, spots);
	}

	public static void combination(int cc, String ustr, int ssf, int ts, Character[] spots) {
		if (cc == ustr.length()) {
			if (ssf == ts) {
				for (int i = 0; i < spots.length; i++)
					System.out.print(spots[i]);

				System.out.println();
			}
			return;
		}
		char ch = ustr.charAt(cc);
		for (int i = 0; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				combination(cc + 1, ustr, ssf + 1, ts, spots);
				spots[i] = null;
			}
		}
		combination(cc + 1, ustr, ssf + 0, ts, spots);

	}

}