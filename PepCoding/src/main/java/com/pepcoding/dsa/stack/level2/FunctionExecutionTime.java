package com.pepcoding.dsa.stack.level2;

import java.util.List;
import java.util.Stack;

public class FunctionExecutionTime {
	 // leetcode 636, https://leetcode.com/problems/exclusive-time-of-functions/
    private class EThelper {
        int id;
        int stime;
        int cet; // child execution time

        public EThelper(int id, int stime, int cet) {
            this.id = id;
            this.stime = stime;
            this.cet = cet;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        // n-> number of IDs
        int[] res = new int[n];
        Stack<EThelper> st = new Stack<>();
        
        for(String str : logs) {
            String[] info = str.split(":");
            int id = Integer.parseInt(info[0]);
            String status = info[1];
            int timeStamp = Integer.parseInt(info[2]);

            if(status.equals("start")) {
                st.push(new EThelper(id, timeStamp, 0));
            } else {
                int fn_diff = timeStamp - st.peek().stime + 1; // function difference time
                int etime = fn_diff - st.peek().cet;  // child execution time

                res[id] += etime;
                st.pop();
                if(st.size() > 0) {
                    st.peek().cet += fn_diff;
                }
            }
        }
        return res;
    }

}
