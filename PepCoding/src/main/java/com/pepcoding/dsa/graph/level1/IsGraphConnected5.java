package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.pepcoding.dsa.graph.level1.GetConnectedComponentGraph4.Edge;

public class IsGraphConnected5 {
	//each vertices should have path to all other vertices
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
	
	private static void getComp(int vtces, ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps) {
		boolean[] visited = new boolean[vtces];
		for (int i = 0; i < vtces; i++) {
			if (visited[i] == false) {// to not visit those which are visited as part of first vertes neighbours
				ArrayList<Integer> comp = new ArrayList<>();
				drawTreeAndGenerateComponent(graph, i, visited, comp);
				comps.add(comp);
			}
		}
// a connceted graph will only have one single component.
		System.out.println(comps.size()==1); 
	}

	private static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
		
		visited[src]=true;
		comp.add(src);
		for(Edge e:graph[src]) {
			int nbr=e.nbr;
			if(visited[nbr]==false)
				drawTreeAndGenerateComponent(graph, nbr, visited, comp);
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

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		getComp(vtces, graph, comps); 

		
	}
}
