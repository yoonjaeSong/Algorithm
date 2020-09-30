package com.raccon.backjoon.math;

import java.util.Arrays;

public class Avenue {
    public int solution(int[] array) {
        Arrays.sort(array);
        int row = array.length;

        int[] interval = new int[row - 1];
        for (int i = 0; i < row - 1; i++) {
            interval[i] = array[i + 1] - array[i];
        }

        Arrays.sort(interval);

        int maxCommonDivisor = interval[0];
        for (int i = 0; i < interval.length - 1; i++) {
            maxCommonDivisor = Math.min(maxCommonDivisor, gcd(interval[i + 1], interval[i]));
        }

        int answer = 0, count = 0;
        for (int i : interval) {
            count = (i / maxCommonDivisor) - 1;
            if (count > 0) {
                answer += count;
            }
        }

        return answer;
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
