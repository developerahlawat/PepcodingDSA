package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class BestMeetingPointArray {
	 // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        // lintcode 912 https://www.lintcode.com/problem/912/
    
        ArrayList<Integer> xcord = new ArrayList<>();
        // fill xcordinate in sorted manner -> row wise traversal
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1)
                    xcord.add(r);
            }
        }
        ArrayList<Integer> ycord = new ArrayList<>();
        // fill ycordinate in sorted manner -> column wise traversal
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1)
                    ycord.add(c);
            }
        }
        // find meeting point
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        int dist = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    dist += Math.abs(x - r) + Math.abs(y - c);
                }  
            }
        }
        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}