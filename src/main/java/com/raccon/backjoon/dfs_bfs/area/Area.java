package com.raccon.backjoon.dfs_bfs.area;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Area {
    private static final int[] moveX = {-1, 1, 0, 0};
    private static final int[] moveY = {0, 0, -1, 1};

    public void solution(int[][] map) {
        Queue<Integer> queue = new PriorityQueue<>();
        int area = 2;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1) {
                    queue.add(findArea(map, area, new int[]{i, j}));
                    area++;
                }
            }
        }

        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private int findArea(int[][] map, int area, int[] point) {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(point);

        int nextX = 0, nextY = 0;
        while (!queue.isEmpty()) {
            int[] currentPoint = queue.poll();

            if (map[currentPoint[0]][currentPoint[1]] > 1) {
                continue;
            }

            map[currentPoint[0]][currentPoint[1]] = area;
            count++;

            for (int i = 0; i < 4; i++) {
                nextY = currentPoint[0] + moveY[i];
                nextX = currentPoint[1] + moveX[i];

                if ((nextX < 0) || (nextX >= map.length) || (nextY < 0) || (nextY >= map.length)) {
                    continue;
                }

                if (map[nextY][nextX] == 1) {
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

        return count;
    }
}
