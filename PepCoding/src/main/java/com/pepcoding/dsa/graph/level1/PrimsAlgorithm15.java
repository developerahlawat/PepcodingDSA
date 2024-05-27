package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.pepcoding.dsa.graph.level1.DijstraAlgorithm14.Edge;
import com.pepcoding.dsa.graph.level1.DijstraAlgorithm14.Pair;

public class PrimsAlgorithm15 {
	/*

Similar to Dijkstra instead of storing path so far will store root vertices for child
and instead of weight so far will only store current child weight.

Prims- min weight used to connect all vertices
	 
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
	
	
	 public static class Pair implements Comparable<Pair> {
	        int src;
	        int parent;
	        int wt;

	        public Pair(int src, int parent, int wt) {
	            this.src = src;
	            this.parent = parent;
	            this.wt = wt;
	        }

	        public int compareTo(Pair o) {
	            return this.wt - o.wt;
	        }
	    }

	    public static void prims(int vtces,ArrayList<Edge>[] graph) {
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(0, -1, 0));
	        boolean[] vis = new boolean[vtces];
	        while(!pq.isEmpty()) {
	        	Pair rem = pq.remove();
	            if(vis[rem.src] == true) {
	                continue;
	            }
	            vis[rem.src] = true;
	            if(rem.parent != -1) {// dont prnt of first vertice
	                System.out.println("[" + rem.src + "-" + rem.parent + "@" + rem.wt + "]");
	            }
	            for(Edge e : graph[rem.src]) {
	                if(vis[e.nbr] == false) {
	                    pq.add(new Pair(e.nbr, rem.src, e.wt));
	                }
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
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2,wt));
			graph[v2].add(new Edge(v2, v1,wt));
		}

		int src = Integer.parseInt(br.readLine());

	    prims(vtces,graph);

	}
}
