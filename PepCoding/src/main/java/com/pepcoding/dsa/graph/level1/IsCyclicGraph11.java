package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsCyclicGraph11 {
	/*
	 * Is graph cyclic- can use either bfs or dfs.
	 * we are using bfs here, will just check if we have visited before and if comes again in queue then connected.
	 * Also need to take care that graph all vertices are not connected then also should work
	 * 
	 * 
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
	 
	 static class Pair{
		   int v;
		   String psf;
		public Pair(int v, String psf) {
			
			this.v = v;
			this.psf = psf;
		}
		   
	   }
	 
	 private static void getCyclic(int vtces, ArrayList<Edge>[] graph) {
			boolean[] visited=new boolean[vtces];
		      for(int v=0;v<vtces;v++)
		    	  if(visited[v]==false) {
		    		  boolean cycle=IsCyclic(graph,v,visited);
		    	     if(cycle)
		    	     {
		    	    	 System.out.println(true);
		    	    	 return;
		    	     }
		    	  }
		      System.out.println(false);
		}
		  
	 
	 private static boolean IsCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
			ArrayDeque<Pair> q=new ArrayDeque<>();
			q.add(new Pair(src,src+""));
			
			while(q.size()>0) {
				Pair rem=q.removeFirst();
				if(visited[rem.v])
					return true;// if already visited then we got the cycle
				visited[rem.v]=true;
				
				for (Edge e : graph[rem.v]) {
					if(visited[e.nbr]==false)
						q.add(new Pair(e.nbr, rem.psf+e.nbr));
					
				}
			}
			return false;
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

	      getCyclic(vtces, graph);
	   }	
}
