package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
	// brick wall, leetcode 554,
	public int leastBricks(List<List<Integer>> walls) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int joint = 0;
        for(List<Integer> layer : walls) {
            int sum = 0;
            for(int i = 0; i < layer.size() - 1; i++) {
                sum += layer.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                if(map.get(sum) > joint) {
                    joint = map.get(sum);
                }
            }
        }
        return walls.size() - joint;
    }
}