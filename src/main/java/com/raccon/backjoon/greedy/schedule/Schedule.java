package com.raccon.backjoon.greedy.schedule;

import java.util.Arrays;

public class Schedule {
    public int solution(int[][] schedule) {
        Arrays.sort(schedule, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return (o1[0] > o2[0]) ? 1 : -1;
            }

            return (o1[1] > o2[1]) ? 1 : -1;
        });

        int count = 1;
        int[] selected = schedule[0];
//        System.out.println(Arrays.toString(selected));
        for (int i = 1; i < schedule.length; i++) {
            if (selected[1] <= schedule[i][0]) {
                selected = schedule[i];
                count++;
//                System.out.println(Arrays.toString(selected));
            }
        }

        return count;
    }
}
