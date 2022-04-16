package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class FaultyKeyBoardString {

	// ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

	// leetcode 925 https://leetcode.com/problems/long-pressed-name/
	public static boolean isLongPressedName(String name, String typed) {
		if (name.length() > typed.length())
			return false;
		
		int i = 0; // name string
		int j = 0; // typed string
		
		while (i < name.length() && j < typed.length()) {
			if (name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if (0 <= i - 1 && name.charAt(i - 1) == typed.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}
		
		while (j < typed.length()) {
			if (typed.charAt(j) != name.charAt(i - 1)) {
				return false;
			}
			j++;
		}
		return i < name.length() ? false : true;
	}

	// ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String name = scn.next();
		String typed = scn.next();

		boolean res = false;
		try {
			res = isLongPressedName(name, typed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(res);
	}
}
