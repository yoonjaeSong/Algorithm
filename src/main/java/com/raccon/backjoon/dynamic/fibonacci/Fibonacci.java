package com.raccon.backjoon.dynamic.fibonacci;

public class Fibonacci {

    private static int[][] dp;
    private static boolean[] checked;

    public int[][] solution(int[] array){
        int[][] answer = new int[array.length][2];

        checked = new boolean[41];
        dp = new int[41][41];

        checked[0] = true;
        checked[1] = true;

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int index = 0;
        for (int n : array) {
            int[] result = fibonacci(n);
            answer[index][0] = result[0];
            answer[index][1] = result[1];

            index++;
        }

        return answer;
    }

    private int[] fibonacci(int n) {

        if(checked[n]){
            return dp[n];
        }else{
            int[] a = fibonacci(n-1);
            int[] b= fibonacci(n-2);

            dp[n][0] = a[0] + b[0];
            dp[n][1] = a[1] + b[1];

            checked[n-1] = true;
            checked[n-2] = true;

            return dp[n];
        }
    }
}
