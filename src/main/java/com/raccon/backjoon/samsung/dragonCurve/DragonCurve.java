package com.raccon.backjoon.samsung.dragonCurve;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DragonCurve {

    private static boolean[][] check;
    private static PriorityQueue<int[]> queue;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public int solution(int[][] inputs) {
        check = new boolean[101][101];
        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (o1[1] > o2[1]) ? 1 : -1;
                }

                return (o1[0] > o2[0]) ? 1 : -1;
            }
        });

        for (int[] input : inputs) {
            int[] start = {input[0], input[1]};
            int generation = input[3];
            if (!check[start[1]][start[0]]) {
                check[start[1]][start[0]] = true;
                queue.add(start);
            }

            make(start, input[2], generation);
        }

        int count = 0;
        int[] point;
        while (!queue.isEmpty()) {
            point = queue.poll();
            if (isRectangle(point)) {
                count++;
            }
        }

        return count;
    }

    private List<Integer> setDirection(int d, int g) {
        List<Integer> list = new ArrayList<>();

        list.add(d);
        for (int i = 1; i <= g; i++) {
            int size = list.size() - 1;
            for (int j = size; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }

        return list;
    }

    private void make(int[] start, int d, int generation) {
        int endX = start[0], endY = start[1];
        List<Integer> list = setDirection(d, generation);

        for (int direction : list) {
            endX += dx[direction];
            endY += dy[direction];
            int[] end = {endX, endY};

            if (!check[end[1]][end[0]]) {
                check[end[1]][end[0]] = true;
                queue.add(end);
            }
        }
    }

    private boolean isRectangle(int[] point) {
        if (point[0] >= 100 || point[1] >= 100) {
            return false;
        }

        return (check[point[1]][point[0] + 1]) &&
                (check[point[1] + 1][point[0]]) &&
                (check[point[1] + 1][point[0] + 1]);
    }
}
