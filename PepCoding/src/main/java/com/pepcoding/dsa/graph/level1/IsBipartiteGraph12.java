package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsBipartiteGraph12 {
	/*
	 * 
Graph is Bipartite if it is possible to divide its vertices into mutually into two mutually exclusive 
and exaustive vetices such that all the edges are across sets

It is extension to cyclic
All Acyclic graph(Trees) is bipartite
All Cyclic graph with even size is bipartite- All component should be bipartite for non connected graph
Every Cyclic graph with odd size is non bipartite


Keep alter level in BFS to another set to make bipartite
Is level is different for a vertice then its not possible to make it  bipartitie

	 */
	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;	
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair {
		int v;
		String psf;
		int level;

		public Pair(int v, String psf, int level) {
			this.v = v;
			this.psf = psf;
			this.level = level;
		}

	}
	
	private static void getBiPartite(int vtces, ArrayList<Edge>[] graph) {
		int[] visited = new int[vtces];

		for (int v = 0; v < vtces; v++) {
			if (visited[v] == -1) {
				//All component should be bipartite for non connected graph
				boolean isComBipartite = checkComponentsForBiPartiteness(graph, v, visited);
				if (isComBipartite == false) {
					System.out.println(false);
					return;
				}
			}
		}
		System.out.println(true);
	}
	
	private static boolean checkComponentsForBiPartiteness(ArrayList<Edge>[] graph, int src, int[] visited) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, src + "", 0));

		while (q.size() > 0) {
			Pair rem = q.removeFirst();

			if (visited[rem.v] != -1) {
				if (rem.level != visited[rem.v])//since levels are not same
					return false;
			} else
				visited[rem.v] = rem.level;

			for (Edge e : graph[rem.v]) {
				if (visited[e.nbr] == -1)
					q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));

			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		getBiPartite(vtces, graph);
	}

	

	
}
