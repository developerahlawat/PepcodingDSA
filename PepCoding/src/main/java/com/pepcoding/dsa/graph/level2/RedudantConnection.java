package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedudantConnection {
	 // leetcode 684. https://leetcode.com/problems/redundant-connection/
	
	static int[] xdir = { -1, 0, 1, 0 };
	static int[] ydir = { 0, -1, 0, 1 };
     class Point {
        int x;
        int y;
        
        Point() { x = 0; y = 0; }
        
        Point(int a, int b) { 
            x = a; y = b;
        }
    }

    public static int find(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static void union(int lx, int ly, int[] rank, int[] parent) {
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
    
     public static int[] findRedundantConnection(int[][] edges) {
        // number of vertices
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // find set leader of both u and v
            int lu = find(parent, u);
            int lv = find(parent, v);
            if(lu == lv) {
                // it means u-v edge is responsible for cycle
                return edge;
            }
            union(lu, lv, rank, parent);
        }
        return new int[0];
    }
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }

}
