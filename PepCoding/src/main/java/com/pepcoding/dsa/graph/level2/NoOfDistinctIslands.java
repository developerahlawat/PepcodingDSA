package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NoOfDistinctIslands {

	// lintcode 860. https://www.lintcode.com/problem/860/

	static int[] xdir = { -1, 0, 1, 0 };
	static int[] ydir = { 0, -1, 0, 1 };

	static StringBuilder str;

	static char[] dir = { 't', 'l', 'd', 'r' };

	private static void distinctCount(int[][] grid, int x, int y) {
		grid[x][y] = 0;
		for (int d = 0; d < 4; d++) {
			int r = x + xdir[d];
			int c = y + ydir[d];

			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
				str.append("" + dir[d]);
				distinctCount(grid, r, c);
			}
		}
		str.append("z");
	}

	public static int numDistinctIslands(int[][] grid) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					str = new StringBuilder("x");
					distinctCount(grid, i, j);
					set.add(str.toString());
				}
			}
		}
		return set.size();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(numDistinctIslands(arr));
	}
}