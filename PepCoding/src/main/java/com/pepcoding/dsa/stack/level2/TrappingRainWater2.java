package com.pepcoding.dsa.stack.level2;

import java.util.PriorityQueue;

public class TrappingRainWater2 {

		 // leetcode 407, https://leetcode.com/problems/trapping-rain-water-ii/
		    private class trwHelper implements Comparable<trwHelper>{
		        int x;
		        int y;
		        int ht;

		        public trwHelper(int x, int y, int ht) {
		            this.x = x;
		            this.y = y;
		            this.ht = ht;
		        }

		        public int compareTo(trwHelper o) {
		            return this.ht - o.ht;
		        }
		    }

		    private void addBoundaryTRW(PriorityQueue<trwHelper> pq, int[][] hts, boolean[][] vis) {
		        // top wall
		        for(int c = 0; c < hts[0].length; c++) {
		            if(vis[0][c] == false) {
		                pq.add(new trwHelper(0, c, hts[0][c]));
		                vis[0][c] = true;
		            }
		        }
		        // left wall
		        for(int r = 0; r < hts.length; r++) {
		            if(vis[r][0] == false) {
		                pq.add(new trwHelper(r, 0, hts[r][0]));
		                vis[r][0] = true;
		            }
		        }
		        // down wall
		        for(int c = 0; c < hts[0].length; c++) {
		            if(vis[hts.length - 1][c] == false) {
		                pq.add(new trwHelper(hts.length - 1, c, hts[hts.length - 1][c]));
		                vis[hts.length - 1][c] = true;
		            }
		        }
		        // right wall
		        for(int r = 0; r < hts.length; r++) {
		            if(vis[r][hts[0].length - 1] == false) {
		                pq.add(new trwHelper(r, hts[0].length - 1, hts[r][hts[0].length - 1]));
		                vis[r][hts[0].length - 1] = true;
		            }
		        }
		    }

		    static int[] xdir = {-1, 0, 1, 0};
		    static int[] ydir = {0, -1, 0, 1};

		    public int trapRainWater(int[][] hts) {
		        boolean[][] vis = new boolean[hts.length][hts[0].length];
		        PriorityQueue<trwHelper> pq = new PriorityQueue<>();

		        // add bounday in pq
		        addBoundaryTRW(pq, hts, vis);
		        int water = 0;
		        while(pq.size() > 0) {
		            trwHelper rem = pq.remove();
		            for(int d = 0; d < 4; d++) {
		                int r = rem.x + xdir[d];
		                int c = rem.y + ydir[d];

		                if(r >= 0 && r < hts.length && c >= 0 && c < hts[0].length && vis[r][c] == false) {
		                    vis[r][c] = true;
		                    if(hts[r][c] < rem.ht) {
		                        water += rem.ht - hts[r][c];
		                        pq.add(new trwHelper(r, c, rem.ht));
		                    } else {
		                        pq.add(new trwHelper(r, c, hts[r][c]));
		                    }
		                }
		            }
		        }

		        return water;
		    }


		}


