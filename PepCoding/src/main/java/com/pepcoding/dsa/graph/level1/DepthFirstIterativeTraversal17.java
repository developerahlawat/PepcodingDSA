package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

import com.pepcoding.dsa.graph.level1.BreadthFirstTraversalGraph10.Edge;
import com.pepcoding.dsa.graph.level1.BreadthFirstTraversalGraph10.Pair;

public class DepthFirstIterativeTraversal17 {
	/*
	 * Till now all Questions we were doing with recursion was DFS which travel on uler
	 * Give shortest path in terms of edges
	 * This is iterative way like BFS just use Stack instead of queue as in BFS 
	 * If replace queue with stack then we get reverse uler
	 * Remove-MarkStar-Work-AddStar
	 * rm*wa*
	 * 
	 * 
	 * 
	 * 
	 * when we can use stack to do DFS question why would we use iterative stack method?
	 * bcose in case of linear graph call stack of function will fillup as its max limit is 10k,
	 * but when we use stack data structure it is space in heap(no limitation in heap of memory)
	 */
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static class Pair {
		int v;
		String psf;

		public Pair(int v, String psf) {

			this.v = v;
			this.psf = psf;
		}

	}
	
	private static void dfs(int vtces, ArrayList<Edge>[] graph, int src) {
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(src, src + ""));
		boolean[] visited = new boolean[vtces];

		while (stack.size() > 0) {
			Pair rem = stack.pop();

			if (visited[rem.v] == true)
				continue;
			visited[rem.v] = true;

			System.out.println(rem.v + "@" + rem.psf);

			for (Edge e : graph[rem.v]) {
				if (visited[e.nbr] == false)
					stack.push(new Pair(e.nbr, rem.psf + e.nbr));

			}
		}
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());

		dfs(vtces, graph, src);

	}
}
