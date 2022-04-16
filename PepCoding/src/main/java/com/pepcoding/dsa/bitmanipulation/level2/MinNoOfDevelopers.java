package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinNoOfDevelopers {
	 // leetcode 1125
    private ArrayList<Integer> ans; // for min selection

    private void smallestSufficientTeam_rec(int devIndx, int[] devMasks, 
        int skillGain, ArrayList<Integer> selectedDevs, int skillCount) {
        // check if all skills are gained
        if(skillGain == ((1 << skillCount) - 1)) {
            // all skills are gained
            // make ans, if answer is already there then skill developers count
            if(ans.size() == 0 || ans.size() > selectedDevs.size()) {
                ans = new ArrayList<>(selectedDevs);
            }
            return;
        }
        // base case
        if(devIndx == devMasks.length) {
            return;
        }
        // no call
        smallestSufficientTeam_rec(devIndx + 1, devMasks, skillGain, selectedDevs, skillCount);
        // yes call
        if(skillGain == devMasks[devIndx]) return;
        skillGain = (skillGain | devMasks[devIndx]);
        selectedDevs.add(devIndx);
        smallestSufficientTeam_rec(devIndx + 1, devMasks, skillGain, selectedDevs, skillCount);
        selectedDevs.remove(selectedDevs.size() - 1);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        // prepare skill to bit mask
        HashMap<String, Integer> skillToBitMap = new HashMap<>();
        for(int i = 0; i < req_skills.length; i++) {
            String skill = req_skills[i];
            skillToBitMap.put(skill, i);
        }
        // prepare dev mask
        int[] devsMask = new int[people.size()];
        int indx = 0;
        for(List<String> skillSet : people) {
            for(String skill : skillSet) {
                int bitForSkill = skillToBitMap.get(skill);
                devsMask[indx] = (devsMask[indx] | (1 << bitForSkill));
            }
            indx++;
        }
        ans = new ArrayList<>();
        smallestSufficientTeam_rec(0, devsMask, 0, new ArrayList<>(), req_skills.length);
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

}
