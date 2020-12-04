package com.raccon.backjoon.hash.p7453;

import java.util.Arrays;

public class P7453 {
    public long solution(long[] A, long[] B, long[] C, long[] D) {
        int n = A.length;
        long[] AB = new long[n * n];
        long[] CD = new long[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int abIndex = 0, cdIndex = CD.length - 1;
        while (abIndex < AB.length && cdIndex >= 0) {
            long sum = AB[abIndex] + CD[cdIndex];
            if (sum == 0) {
                long ab = AB[abIndex], cd = CD[cdIndex];
                long abCount = 0, cdCount = 0;

                while (abIndex < AB.length && ab == AB[abIndex]) {
                    abCount++;
                    abIndex++;
                }

                while (cdIndex >= 0 && cd == CD[cdIndex]) {
                    cdCount++;
                    cdIndex--;
                }

                answer += abCount * cdCount;
            } else if (sum > 0) {
                cdIndex--;
            } else {
                abIndex++;
            }
        }

        return answer;
    }
}
