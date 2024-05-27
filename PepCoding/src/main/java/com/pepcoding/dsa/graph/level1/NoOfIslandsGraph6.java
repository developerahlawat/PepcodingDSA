package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NoOfIslandsGraph6 {
	//application of get connected component
	//here we have 2d array instead of list
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}

		getIsland(arr);
	}

	private static void getIsland(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0 && visited[i][j] == false) {// land is represted by zero
					drawTreeForComponents(arr, i, j, visited);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void drawTreeForComponents(int[][] arr, int i, int j, boolean[][] visited) {
		// if are inside board //  
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true)
			return;

		//could have also put if condition about land here, but using is above base case both are correct.
		visited[i][j] = true;//will call neighbours instead of 
		drawTreeForComponents(arr, i - 1, j, visited);//north neighbours
		drawTreeForComponents(arr, i, j + 1, visited);//east
		drawTreeForComponents(arr, i + 1, j, visited);//soouth
		drawTreeForComponents(arr, i, j - 1, visited);//west

	}
}
