package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle8 {
// similar to print all path
//	Hamiltonian Path- end with dot,it is a path start with source going through all the source without repeating
//  Hamiltonian Cycle - end with Star, a path becomes a cycles when first and last vertice has same edge
//	
	
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

		int src = Integer.parseInt(br.readLine());

		HashSet<Integer> visited = new HashSet<>();
		hamiltonian(graph, src, visited, src + "", src);
	}

	private static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {

		if (visited.size() == graph.length - 1) {
			//since current source is not yet added in visited, common mistake people do
			System.out.print(psf);

			boolean closingEdgeFound = false;
			for (Edge e : graph[src]) {
				if (e.nbr == osrc) {// if original source is connected with current source
					closingEdgeFound = true;//hence a hamiltonian cycle
					break;
				}
			}
			if (closingEdgeFound)
				System.out.println("*");
			else
				System.out.println(".");

			return;
		}
		//similar to print all path,just base case are diffrent
		visited.add(src);
		for (Edge e : graph[src]) {
			if (visited.contains(e.nbr) == false)
				hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
		}
		visited.remove(src);

	}

}
