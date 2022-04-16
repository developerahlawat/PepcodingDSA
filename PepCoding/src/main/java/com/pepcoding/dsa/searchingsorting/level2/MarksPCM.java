package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Arrays;
import java.util.Scanner;

public class MarksPCM {
	// marks of PCM https://practice.geeksforgeeks.org/problems/marks-of-pcm2529/1
	
	
	public static class Students implements Comparable<Students> {
        int phy;
        int chem;
        int maths;


        public Students(int phy, int chem, int maths) {
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }

        public int compareTo(Students o) {
            if(this.phy == o.phy) {
                // decision depends on chemistry
                if(this.chem == o.chem) {
                    // decision depends on maths, default behaviour
                    return this.maths - o.maths;
                } else {
                    // reverse of default behaviour
                    return o.chem - this.chem;
                }
            } else {
                // default behaviour, increasing order requirement
                return this.phy - o.phy;
            }
        }
    }
	
    public static void customSort(int[]phy,int[]chem,int[]math) {
    	 Students[] sarr = new Students[phy.length];

         for(int i = 0; i < phy.length; i++) {
             sarr[i] = new Students(phy[i], chem[i], math[i]);
         }

         Arrays.sort(sarr);
         for(int i = 0; i < phy.length; i++) {
             phy[i] = sarr[i].phy;
             chem[i] = sarr[i].chem;
             math[i] = sarr[i].maths;
         }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}