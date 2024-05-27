package com.pepcoding.dsa.graph.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.pepcoding.dsa.graph.level1.GetConnectedComponentGraph4.Edge;

public class PerfectFriendGraph7 {
	//application of get connected components
	// group of freinds in a bar
	//need to find unique pair of friends
	//Total pair will be 
	public static class Edge{
		int src;
		int nbr;
		public Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
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

		int pairs=0;
		for(int i=0;i<comps.size();i++) {
			for(int j=i+1;j<comps.size();j++) {
				int count=comps.get(i).size() * comps.get(j).size();
				pairs+=count;
			}
		}
		  
    	  
        System.out.println(pairs);
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

	      int n = Integer.parseInt(br.readLine());
	      int k = Integer.parseInt(br.readLine());
	      
	      ArrayList<Edge>[] graph=new ArrayList[n];
	      for(int v=0;v<n;v++)
	    	  graph[v]=new ArrayList<>();
	      
	      for(int e=0;e<k;e++) {
	    	  String line =br.readLine();
	    	  String[] parts=line.split(" ");
	    	  
	    	  int v1=Integer.parseInt(parts[0]);
	    	  int v2=Integer.parseInt(parts[1]);
	    	  
	    	  graph[v1].add(new Edge(v1,v2));
	    	  graph[v2].add(new Edge(v2, v1));
	      }
	      
	      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
	    	 
	      getComp(n, graph,comps);	 
	 }

	
}
