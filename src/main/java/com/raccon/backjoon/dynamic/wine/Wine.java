package com.raccon.backjoon.dynamic.wine;

public class Wine {
    public int solution(int[] wines){
        int n = wines.length;
        int answer = 0;

        if (n == 1) {
            return wines[0];
        } else if (n == 2) {
            return wines[0] + wines[1];
        } else if (n == 3) {
            answer = Math.max(wines[2] + wines[1], wines[2] + wines[0]);
            answer = Math.max(answer, wines[1] + wines[0]);
            return answer;
        }

        int[] dp = new int[n];
        dp[0] = wines[0];
        dp[1] = wines[1] + dp[0];
        dp[2] = Math.max(dp[1], Math.max(wines[2] + wines[1], wines[2] + wines[0]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(wines[i] + wines[i - 1] + dp[i - 3], wines[i] + dp[i - 2]);
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        return dp[n-1];
    }
}
