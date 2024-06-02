package com.pepcoding.dsa.graph.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.pepcoding.dsa.graph.level2.DFS.Edge;

public class BFS01 {
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

	public static class BPair {
		int vtx;
		int wsf;
		String psf;
		

		public BPair(int vtx, int wsf, String psf) {
			this.vtx = vtx;
			this.psf = psf;
			this.wsf = wsf;
		}
	}

	public static boolean bfs(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis) {
		Queue<BPair> qu = new LinkedList<>();
		qu.add(new BPair(src, 0, "" + src));
		boolean res = false;
		while (qu.size() > 0) {
			// 1. get + remove
			BPair rem = qu.remove();
			// 2. mark *
			if (vis[rem.vtx] == true)
				continue;
			vis[rem.vtx] = true;
			// 3. work
			System.out.println(rem.vtx + " " + rem.psf + " @ " + rem.wsf);
			if (src == dst) {
				res = true;
				break;
			}
			// 4. add neighbours
			for (Edge e : graph[rem.vtx]) {
				if (vis[e.nbr] == false) {
					qu.add(new BPair(e.nbr, rem.wsf + e.wt, rem.psf + e.nbr));
				}
			}
		}
		return res;
	}
}
