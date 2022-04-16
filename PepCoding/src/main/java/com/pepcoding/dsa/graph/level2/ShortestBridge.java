package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	// leetcode 934. https://leetcode.com/problems/shortest-bridge/

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

	private static void dfsShortestBridge(int[][] grid, int x, int y, Queue<pairD> qu) {
		grid[x][y] = -1;
		qu.add(new pairD(x, y, 0));
		for (int d = 0; d < 4; d++) {
			int r = x + xdir[d];
			int c = y + ydir[d];

			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
				dfsShortestBridge(grid, r, c, qu);
			}
		}

	}

	public static int shortestBridge(int[][] grid) {
		Queue<pairD> qu = new LinkedList<>();
		// 1. add all one in queue, using DFS from first one encoutered
		loop: for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfsShortestBridge(grid, i, j, qu);
					break loop;
				}
			}
		}
		// 2. apply BFS on queue and return level when another one is encounter
		while (qu.size() > 0) {
			pairD rem = qu.remove();
			for (int d = 0; d < 4; d++) {
				int r = rem.x + xdir[d];
				int c = rem.y + ydir[d];
				if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1) {
					if (grid[r][c] == 1) {
						return rem.l;
					}
					grid[r][c] = -1;
					qu.add(new pairD(r, c, rem.l + 1));
				}
			}

		}

		return -1;
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

		System.out.println(shortestBridge(arr));

	}

}