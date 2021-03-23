package com.raccon.backjoon.dynamic.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS
public class P9251 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String[] a;
    private static String[] b;

    private static int[][] dp;

    public int solution() throws IOException {
        a = br.readLine().split("");
        b = br.readLine().split("");

        dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if(a[i-1].equals(b[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[a.length][b.length];
    }
}
