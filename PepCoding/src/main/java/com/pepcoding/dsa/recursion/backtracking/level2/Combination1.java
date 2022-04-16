package com.pepcoding.dsa.recursion.backtracking.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combination1 {
	public static void combinations(int currentBox, int totalBox, int selectionSoFar, int totalSelection,
			String andSoFar) {
		if (currentBox > totalBox) {
			if (selectionSoFar == totalSelection)
				System.out.println(andSoFar);
			return;
		}
		combinations(currentBox + 1, totalBox, selectionSoFar + 1, totalSelection, andSoFar + "i");
		combinations(currentBox + 1, totalBox, selectionSoFar, totalSelection, andSoFar + "-");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nboxes = Integer.parseInt(br.readLine());
		int ritems = Integer.parseInt(br.readLine());
		combinations(1, nboxes, 0, ritems, "");
	}

}
