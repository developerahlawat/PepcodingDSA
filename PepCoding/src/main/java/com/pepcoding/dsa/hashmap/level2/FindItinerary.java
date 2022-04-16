package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class FindItinerary {
	public static void printIntinerary(HashMap<String, String> connections) {
        HashMap<String, Boolean> begin = new HashMap<>();
        for(String start : connections.keySet()) {
            String end = connections.get(start);
            begin.put(end, false); // update or insert
            if(begin.containsKey(start) == false) {
                begin.put(start, true);
            }
        }
        String src = "";
        for(String key : begin.keySet()) {
            if(begin.get(key) == true) {
                src = key;
                break;
            }
        }

        System.out.print(src);
        while(connections.containsKey(src)) {
            src = connections.get(src);
            System.out.print(" -> " + src);
        }
        System.out.println(".");
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
	printIntinerary(map);
	}
}
