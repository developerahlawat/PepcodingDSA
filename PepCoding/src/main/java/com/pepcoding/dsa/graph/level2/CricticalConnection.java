package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CricticalConnection {
	
	 // leetcode 1192. https://leetcode.com/problems/critical-connections-in-a-network/
    
	 static int time = 0;

	    private static void dfsArticulation(ArrayList<ArrayList<Integer>> graph, 
	    int src, boolean[] vis, int[] parent, int[] disc, int[] low, boolean[] arti,
	    List<List<Integer>> res) {
	        disc[src] = low[src] = time;
	        time++;
	        vis[src] = true;
	        int count = 0; // count for finding original source status about articulation
	        for(int nbr : graph.get(src)) {
	            if(vis[nbr] == true && parent[src] != nbr) {
	                // visited but not parent
	                low[src] = Math.min(low[src], disc[nbr]);
	            } else if(vis[nbr] == false) {
	                // unvisited neighbour
	                parent[nbr] = src;
	                dfsArticulation(graph, nbr, vis, parent, disc, low, arti, res);
	                low[src] = Math.min(low[src], low[nbr]);
	                count++; // increment in count if we are making call to nbr
	                if(disc[src] < low[nbr]) {
	                    List<Integer> edge = new ArrayList<>();
	                    edge.add(src);
	                    edge.add(nbr);
	                    res.add(edge);
	                    arti[src] = true;
	                }
	            }
	        }
	    }

	    private static List<List<Integer>> articulationBridge(ArrayList<ArrayList<Integer>> graph) {
	        int count = 0;
	        int n = graph.size();
	        int[] parent = new int[n];
	        int[] disc = new int[n];
	        int[] low = new int[n];
	        boolean[] vis = new boolean[n];
	        boolean[] arti = new boolean[n];
	        parent[0] = -1; // parent of starting point is -1
	        time = 0;
	        List<List<Integer>> res = new ArrayList<>();
	        dfsArticulation(graph,  0, vis, parent, disc, low, arti, res); 
	        return res;
	    }

	    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        for(int i = 0; i < n; i++) {
	            graph.add(new ArrayList<>());
	        }

	        for(List<Integer> edge : connections) {
	            int v1 = edge.get(0);
	            int v2 = edge.get(1);

	            graph.get(v1).add(v2);
	            graph.get(v2).add(v1);
	        }
	        List<List<Integer>> res = articulationBridge(graph);
	        return res;
	    }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] st = br.readLine().split(" ");
	    int n = Integer.parseInt(st[0]);
	    int e = Integer.parseInt(st[1]);
	    List<List<Integer>> edges = new ArrayList<>();


	    for (int i = 0; i < e; i++) {
	      edges.add(new ArrayList<>());
	      st = br.readLine().split(" ");
	      edges.get(i).add(Integer.parseInt(st[0]));
	      edges.get(i).add(Integer.parseInt(st[1]));
	    }

	    System.out.println(criticalConnections(n, edges));

	  }

	}