package com.raccon.backjoon.greedy.rope;

import java.util.Arrays;

public class Rope {
    public int solution(int[] ropes){
        Arrays.sort(ropes);

        int k = ropes.length, max = 0;
        for (int rope : ropes) {
            if (max < (rope * k)) {
                max = rope * k;
            }
            k--;
        }

        return max;
    }
}
