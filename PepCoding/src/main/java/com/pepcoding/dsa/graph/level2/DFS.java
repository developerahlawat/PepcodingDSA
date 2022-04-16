package com.pepcoding.dsa.graph.level2;

import java.util.ArrayList;

public class DFS {

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {
		graph[v1].add(new Edge(v2, wt));
		graph[v2].add(new Edge(v1, wt));
	}

	public static void solve() {
		int n = 7;
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		addEdge(graph, 0, 1, 10);
		/* and so on.... */
	}



	public boolean dfs(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis, String psf) {
		if (src == dst) {
			psf += dst;
			System.out.println(psf);
			return true;
		}
		// vis[src] = true;
		// for(Edge e : graph[src]) {
		// if(vis[e.nbr] == false) {
		// if(dfs(graph, e.nbr, dst, vis, psf + src) == true) {
		// return true;
		// }
		// }
		// }
		// return false;
		vis[src] = true;
		boolean res = false;
		for (Edge e : graph[src]) {
			if (vis[e.nbr] == false) {
				res = res || dfs(graph, e.nbr, dst, vis, psf + src);
			}
		}
		return res;
	}
}
