package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijstraAlgorithm14 {
	/*
Find shorted path in terms of weight similar to BFS just use priority queueue .
For shorted path in terms of edges use BFS.


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
        String psf;//path so far
        int wsf;//weight so far
 
        public Pair(int src, String psf, int wsf) {
            this.src = src;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        } 
    }
	
	public static void dijkstras(int vrcts,ArrayList<Edge>[] graph, int src) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, "" + src, 0));
        boolean[] vis = new boolean[vrcts];

        while(pq.size() > 0) {
        	Pair rem = pq.remove();
            if(vis[rem.src] == true) {
                continue;
            }
            vis[rem.src] = true;
            System.out.println(rem.src + " via " + rem.psf + " @ " + rem.wsf);
            for(Edge e : graph[rem.src]) {
                if(vis[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
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

		dijkstras(vtces, graph, src);

	}
}

