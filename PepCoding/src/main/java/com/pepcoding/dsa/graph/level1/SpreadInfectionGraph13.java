package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadInfectionGraph13 {
	/*
	 * 
Using BFS to  	 
	 */
	static class Edge {
	      int src;
	      int nbr;

	      Edge(int src, int nbr) {
	         this.src = src;
	         this.nbr = nbr;
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
	      int t = Integer.parseInt(br.readLine());
	      
	      getInfected(vtces, graph, src, t);
	      
	   }
	private static void getInfected(int vtces, ArrayList<Edge>[] graph, int src, int t) {
		ArrayDeque<Pair> q=new ArrayDeque<>();
	      q.add(new Pair(src, 1));
	      int[] visited=new int[vtces];
	      int count=0;
	      
	      while(q.size()>0) {
	    	  Pair rem=q.removeFirst();
	    	  
	    	  if(visited[rem.v]>0)
	    		  continue;
	    	  visited[rem.v]=rem.time;
	    	  if(rem.time>t)
	    		  break;
	    	  count++;
	    	  for (Edge e : graph[rem.v]) {
	    		  if(visited[e.nbr]==0)
	    			  q.add(new Pair(e.nbr, rem.time+1));
			}
	      }
	      System.out.println(count);
	}
	   public static class Pair{
		   int v;
		   int time;
		public Pair(int v, int time) {
			this.v = v;
			this.time = time;
		}
		   
	   }
}
