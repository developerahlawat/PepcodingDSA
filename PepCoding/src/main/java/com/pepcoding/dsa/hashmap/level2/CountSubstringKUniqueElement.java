package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubstringKUniqueElement {
	private static int handleWhenK1(String str) {
		int acq = -1;
		int rel = -1;
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;

			while (acq < str.length() - 1) {
				flag1 = true;
				acq++;
				char ch = str.charAt(acq);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.size() == 2) {
					map.remove(ch);
					acq--;
					break;
				}
			}

			while (rel < acq) {
				count += acq - rel;
				rel++;
				char ch = str.charAt(rel);
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					map.remove(ch);

				if (map.size() == 0)
					break;
			}

			if (flag1 == false && flag2 == false) {
				break;
			}
		}

		return count;
	}

	private static int countSubStringExactlyK(String str, int k) {
		if (k == 1) {
			return handleWhenK1(str);
		}
		HashMap<Character, Integer> mapb = new HashMap<>();
		HashMap<Character, Integer> maps = new HashMap<>();

		int count = 0;

		int is = -1;
		int ib = -1;
		int j = -1;

		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			// k - 1 for map small
			while (is < str.length() - 1) {
				flag1 = true;
				is++;
				char ch = str.charAt(is);
				maps.put(ch, maps.getOrDefault(ch, 0) + 1);
				if (maps.size() == k) {
					maps.remove(ch);
					is--;
					break;
				}
			}
			// k for map big
			while (ib < str.length() - 1) {
				flag2 = true;
				ib++;
				char ch = str.charAt(ib);
				mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
				if (mapb.size() == k + 1) {
					mapb.remove(ch);
					ib--;
					break;
				}
			}
			// release
			while (j < is) {
				flag3 = true;
				if (mapb.size() == k && maps.size() == k - 1) {
					count += ib - is;
				}
				j++;
				char ch = str.charAt(j);
				// remove from maps
				maps.put(ch, maps.get(ch) - 1);
				if (maps.get(ch) == 0)
					maps.remove(ch);
				// remove from mapb
				mapb.put(ch, mapb.get(ch) - 1);
				if (mapb.get(ch) == 0)
					mapb.remove(ch);

				if (maps.size() < k - 1 || mapb.size() < k) {
					break;
				}
			}
			if (flag1 == false && flag2 == false && flag3 == false)
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		System.out.println(countSubStringExactlyK(str, k));
	}

}
