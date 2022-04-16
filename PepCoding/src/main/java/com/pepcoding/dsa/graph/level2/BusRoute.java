package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoute {
	// leetcode 815. https://leetcode.com/problems/bus-routes/
	private static void makeMapWithStandAndBus(int[][] routes, HashMap<Integer, ArrayList<Integer>> map) {
		for (int r = 0; r < routes.length; r++) { // r -> bus number
			for (int c = 0; c < routes[r].length; c++) {
				int stand = routes[r][c];
				if (map.containsKey(stand) == true) {
					// key is already present, so just add value i.e. bus number with that bus stop
					map.get(stand).add(r);
				} else {
					ArrayList<Integer> busNo = new ArrayList<>();
					busNo.add(r);
					map.put(stand, busNo);
				}
			}
		}
	}

	public static int numBusesToDestination(int[][] routes, int source, int target) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		makeMapWithStandAndBus(routes, map);

		HashSet<Integer> visBus = new HashSet<>();
		HashSet<Integer> visStand = new HashSet<>();
		Queue<Integer> qu = new LinkedList<>();
		qu.add(source);
		int level = -1;
		while (qu.size() > 0) {
			int size = qu.size();
			level++;
			while (size-- > 0) {
				int rem = qu.remove();

				if (rem == target)
					return level;

				for (int busNum : map.get(rem)) {
					if (visBus.contains(busNum) == true) {
						continue;
					} else {
						for (int busStand : routes[busNum]) {
							if (visStand.contains(busStand) == false) {
								visStand.add(busStand);
								qu.add(busStand);
							}
						}
						visBus.add(busNum);
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		String[] st1 = br.readLine().split(" ");
		int src = Integer.parseInt(st1[0]);
		int dest = Integer.parseInt(st1[1]);
		System.out.println(numBusesToDestination(arr, src, dest));

	}

}
