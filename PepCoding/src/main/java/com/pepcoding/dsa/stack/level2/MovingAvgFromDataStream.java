package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAvgFromDataStream {
	// moving average from data stream, portal
    public static class MovingAverage {
        Queue<Integer> qu;
        double sum;
        int k;
        public MovingAverage(int size) {
            qu = new ArrayDeque<>();
            sum = 0;
            k = size;
        }
    
        public double next(int val) {
            if(qu.size() < k) {
                sum += val;
                qu.add(val);
                return sum / qu.size();
            } else{
                sum -= qu.remove();
                sum += val;
                qu.add(val);
                return sum / k;
            }
        }
    }


  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(read.readLine());
    MovingAverage obj = new MovingAverage(size);
    PrintWriter out = new PrintWriter(System.out);
    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      double avg = obj.next(val);

      StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
      while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }
      out.println(ans);
    }
    out.close();
  }

}
