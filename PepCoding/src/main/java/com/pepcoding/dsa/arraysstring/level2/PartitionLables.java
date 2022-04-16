package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLables {
	// leetcode 763. https://leetcode.com/problems/partition-labels/
    public List<Integer> partitionLabels(String s) {
        // 1. Make hashmap of last occurence
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        // 2. solve using chaining technique
        List<Integer> res = new ArrayList<>();

        int prev = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            max = Math.max(max, map.get(ch));
            if(max == i) {
                res.add(i - prev + 1);
                prev = i + 1;
            }
        }
        return res;
    }
    
}
