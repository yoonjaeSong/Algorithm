package com.raccon.backjoon.binray.sequenceMax;

import java.util.ArrayList;
import java.util.List;

public class P11053 {
    public int[] solution(int[] array) {
        List<Integer> sequence = new ArrayList<>();
        int[] dp = new int[array.length];

        sequence.add(array[0]);
        dp[0] = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > sequence.get(sequence.size() - 1)) {
                sequence.add(array[i]);
                dp[i] = sequence.size();
                continue;
            }

            // 현재 값 <= 이전 값
            int index = lowerBound(sequence, array[i]);
            sequence.set(index, array[i]);
            dp[i] = index + 1;
        }

        int size = sequence.size();
        int[] answer = new int[sequence.size()];
        for (int i = dp.length - 1; i >= 0; i--) {
            if(dp[i] == size){
                size--;
                answer[size] = array[i];
            }
        }

        return answer;
    }

    private int lowerBound(List<Integer> sequence, int target) {
        int start = 0, end = sequence.size() - 1;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (sequence.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
