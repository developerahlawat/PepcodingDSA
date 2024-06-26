package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HasPathGraph1 {//dfs
	public static class Edge {
		int src;
		int nbr;
		int wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	private static boolean solution(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if (src == dest)
			return true;

		visited[src] = true;
		for (Edge e : graph[src]) {
			int nbr = e.nbr;
			if (visited[nbr] == false) {
				boolean ntod = solution(graph, nbr, dest, visited);
				if (ntod)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		//ArrayList<ArrayList<Edge>> group = new ArrayList<ArrayList<Edge>>(vtces);
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
			//group.add(i,new ArrayList<>());
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
			//group.get(v1).add(new Edge(v1, v2, wt));
			//group.get(v2).add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[vtces];
		System.out.println(solution(graph, src, dest, visited));
	}

}
