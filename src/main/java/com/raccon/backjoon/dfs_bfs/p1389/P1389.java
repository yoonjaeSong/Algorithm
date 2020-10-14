package com.raccon.backjoon.dfs_bfs.p1389;

import java.util.LinkedList;
import java.util.Queue;

public class P1389 {

    private static int[][] relation;

    public int solution(int n, int[][] inputs) {
        relation = new int[n][n];

        int a, b;
        for (int[] input : inputs) {
            relation[input[0] - 1][input[1] - 1] = 1;
            relation[input[1] - 1][input[0] - 1] = 1;
        }

        int min = Integer.MAX_VALUE, answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = bfs(n, i);
            if (min > temp) {
                answer = (i + 1);
                min = temp;
            }
        }

        return answer;
    }

    private static int bfs(int n, int start) {
        boolean[] checked = new boolean[n];
        int[] array = new int[n];

        array[0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        checked[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();

            for (int i = 0; i < n; i++) {
                if (!checked[i] && relation[info[0]][i] == 1) {
                    checked[i] = true;
                    array[i] = info[1];
                    queue.add(new int[]{i, info[1] + 1});
                }
            }
        }

        int result = 0;
        for (int value : array) {
            result += value;
        }

        return result;
    }
}
