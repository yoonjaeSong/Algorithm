package com.raccon.backjoon.binray.sequenceMax;

import java.util.ArrayList;
import java.util.List;

public class P11054 {
    public int solution(int[] array){
        int num = array.length, index = 0;
        int[][] dp = new int[2][num]; // int[0]의 방향 -> | int[1]의 방향 <-
        List<Integer> list = new ArrayList<>();

        dp[0][0] = 1;
        list.add(array[0]);

        // 방향 ->
        for (int i = 1; i < num; i++) {
            if (array[i] > list.get(list.size() - 1)) {
                list.add(array[i]);
                dp[0][i] = list.size();
                continue;
            }

            index = lowBoundary(list, array[i]);
            list.set(index, array[i]);
            dp[0][i] = index + 1;
        }

        // 방향 <-
        list = new ArrayList<>();

        dp[1][num - 1] = 1;
        list.add(array[num-1]);

        for(int i = num-2; i>=0; i--){
            if(array[i] > list.get(list.size()-1)){
                list.add(array[i]);
                dp[1][i] = list.size();
                continue;
            }

            index = lowBoundary(list, array[i]);
            list.set(index, array[i]);
            dp[1][i] = index+1;
        }

        int max = 0;
        for(int i=0; i<num; i++){
            int temp = dp[0][i] + dp[1][i];
            max = Math.max(max, temp);
        }

        return max-1;
    }
    private int lowBoundary(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
