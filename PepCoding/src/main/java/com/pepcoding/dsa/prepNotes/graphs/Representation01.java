package com.pepcoding.dsa.prepNotes.graphs;

import java.util.ArrayList;



public class Representation01 {
	
	public static class Edge {
		int src;
		int nbr;
		int wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
		
		@Override
	    public String toString() {
	        return "(" + src + " -- " + wt + " --> " + nbr + ")";
	    }
	}
	
	public static void main(String[] args) throws Exception {
		representGraphUsingAdjacencyMatrix();
		System.out.println("-----------**************-----------");
		representGraphUsingAdjacencyList();	 	
	}
	
	
	

	private static void representGraphUsingAdjacencyMatrix() {
		int vtces = 5;  // Predefined number of vertices
		int[][] graph = new int[vtces][vtces];
		
		 // Predefined edges
        int[][] edges = {
            {0, 1, 10},
            {0, 4, 20},
            {1, 2, 30},
            {1, 3, 40},
            {2, 3, 50},
            {3, 4, 60}
        };

        // Initialize the graph with 0 indicating no edge
        for (int i = 0; i < vtces; i++) {
            for (int j = 0; j < vtces; j++) {
                graph[i][j] = 0;
            }
        }


        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            int wt = edge[2];
            graph[v1][v2] = wt;
            graph[v2][v1] = wt; // For undirected graph
        }

        printGraph(graph);
	}

	private static void representGraphUsingAdjacencyList() {
		int vtces = 5;  // Predefined number of vertices
		
	    // Predefined edges
        int[][] edges = {
            {0, 1, 10},
            {0, 4, 20},
            {1, 2, 30},
            {1, 3, 40},
            {2, 3, 50},
            {3, 4, 60}
        }; 
		
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

        
		for (int[] edge : edges) {
	          int v1 = edge[0];
	          int v2 = edge[1];
	          int wt = edge[2];
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}
		
		printGraphList(graph);
	}
	
	public static void printGraphList(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge e : graph[i]) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
	
	 public static void printGraph(int[][] graph) {
	        int vtces = graph.length;
	        for (int i = 0; i < vtces; i++) {
	            System.out.print("Vertex " + i + ": ");
	            for (int j = 0; j < vtces; j++) {
	                if (graph[i][j] != 0) {
	                    System.out.print("(" + i + " -- " + graph[i][j] + " --> " + j + ") ");
	                }
	            }
	            System.out.println();
	        }
	    }

}
