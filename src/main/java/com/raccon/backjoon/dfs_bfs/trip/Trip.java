package com.raccon.backjoon.dfs_bfs.trip;

import java.util.*;

public class Trip {

    private static Map<Integer, Set<Integer>> map;

    public String solution(int city, int[][] input, int[] plan) {
        map = new HashMap<>();
        for (int i = 1; i <= city; i++) {
            map.put(i, new HashSet<>());
            for (int j = 1; j <= city; j++) {
                if (input[i][j] == 1) {
                    map.get(i).add(j);
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < plan.length - 1; i++) {
            if (!isPossible(plan[i], plan[i + 1])) {
                flag = false;
                break;
            }
        }

        return flag ? "YES" : "NO";
    }

    private boolean isPossible(int start, int target) {
        boolean[] visited = new boolean[map.size() + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            if (city == target) {
                return true;
            }

            for (int next : map.get(city)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }
}
