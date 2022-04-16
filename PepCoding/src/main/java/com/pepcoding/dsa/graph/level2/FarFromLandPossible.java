package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FarFromLandPossible {
	 // leetcode 1162. https://leetcode.com/problems/as-far-from-land-as-possible/
	
	static int[] xdir = { -1, 0, 1, 0 };
	static int[] ydir = { 0, -1, 0, 1 };

	private static class pairD {
		int x;
		int y;
		int l;

		public pairD(int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	public static int maxDistance(int[][] grid) {
		// 1. iterate on grid and add all one's in queue and mark it as well
		Queue<pairD> qu = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					qu.add(new pairD(i, j, 0));
					grid[i][j] = -1;
				}
			}
		}

		// run BFS
		if (qu.size() == 0 || qu.size() == grid.length * grid[0].length)
			return -1;

		int level = -1;
		while (qu.size() > 0) {
			pairD rem = qu.remove();
			for (int d = 0; d < 4; d++) {
				int r = rem.x + xdir[d];
				int c = rem.y + ydir[d];

				if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1) {
					qu.add(new pairD(r, c, rem.l + 1));
					grid[r][c] = -1;
					level=Math.max(level,rem.l+1);
				}
			}
		}

		return level;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(maxDistance(arr));

	}

}
