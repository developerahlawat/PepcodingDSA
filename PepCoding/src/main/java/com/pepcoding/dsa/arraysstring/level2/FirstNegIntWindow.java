package com.pepcoding.dsa.arraysstring.level2;

public class FirstNegIntWindow {
	// first -ve in k size window, https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        int indx = N;
        long[] res = new long[N - (K - 1)];
        // mark -ve in last k size window
        for(int i = N - 1; i >= N - K; i--) {
            if(A[i] < 0) 
                indx = i;
        }
        // travel from N - K to 0 and set in result
        for(int i = N - K; i >= 0; i--) {
            if(A[i] < 0) 
                indx = i;

            if(indx < i + K) {
                res[i] = A[indx];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
