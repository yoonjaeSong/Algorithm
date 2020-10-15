package com.raccon.backjoon.dfs_bfs.p2583;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Area {

    private static final int[] moveX = {-1, 1, 0, 0};
    private static final int[] moveY = {0, 0, -1, 1};

    private static int[][] map;

    public int[] solution(int m, int n, int[][] inputs) {
        map = new int[m][n];

        for (int[] input : inputs) {
            setRectangle(input[0], input[1], input[2], input[3]);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1) {
                    priorityQueue.add(draw(new int[]{i, j}));
                    count++;
                }
            }
        }

        int[] answer = new int[count];
        int index = 0;
        while(!priorityQueue.isEmpty()){
            answer[index++] = priorityQueue.poll();
        }

        return answer;
    }

    private int draw(int[] start) {
        Queue<int[]> queue = new LinkedList<>();

        int result = 1;
        queue.add(start);
        map[start[0]][start[1]] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + moveY[i];
                int nx = point[1] + moveX[i];

                if ((nx < 0) || (ny < 0) || (nx >= map[0].length) || (ny >= map.length)) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    queue.add(new int[]{ny, nx});
                    result++;
                }
            }
        }

        return result;
    }

    private void setRectangle(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = 1;
            }
        }
    }
}
