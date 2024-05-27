package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import com.pepcoding.dsa.graph.level1.GetConnectedComponentGraph4.Edge;

public class TopologicalSort16 {
	/*
Topological sort -A permutation of vertices for a directed a cyclic graph is called topological sort
is used to solve directed  graph.


Will use DFS, similar to get connected component.

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
	
	 public static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src, boolean[] vis, Stack<Integer> st) {

	        //we can't print in pre order we had to take stack because as it 
	        //doesn't work were two components are conecting   
	       vis[src] = true;
	        
	        for(Edge e : graph[src]) {
	            if(vis[e.nbr] == false) {
	            	drawTreeAndGenerateComponent(graph, e.nbr, vis, st);
	            }
	        }
	        st.push(src);
	        //if print in post Order - it will print order of work which is reverse of topological sort
	    }

	    public static void topologicalSort(int vtces,ArrayList<Edge>[] graph) {
	        boolean[] vis = new boolean[graph.length];
	        Stack<Integer> st = new Stack<>();
	        for(int v = 0; v < graph.length; v++) {
	            if(vis[v] == false) {
	            	drawTreeAndGenerateComponent(graph, v, vis, st);
	            }
	        }

	        while(st.size() > 0) {
	            System.out.println(st.pop());
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
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}


		topologicalSort(vtces,graph); 
	}


}
