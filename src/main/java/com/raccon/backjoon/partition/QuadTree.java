package com.raccon.backjoon.partition;

public class QuadTree {
    public String solution(int[][] map) {
        int n = map.length - 1;
        return partition(map, 0, n, 0, n);
    }

    private String partition(int[][] map, int x1, int x2, int y1, int y2) {
        StringBuilder sb = new StringBuilder();
        int midX = (x1 + x2) / 2, midY = (y1 + y2) / 2;
        int[][] xArray = {{x1, midX}, {midX + 1, x2}}, yArray = {{y1, midY}, {midY + 1, y2}};

        int value = map[y1][x1];
        if (check(map, x1, x2, y1, y2, value)) {
            return sb.append(value).toString();
        }

        sb.append("(");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int[] x = xArray[j];
                int[] y = yArray[i];
                value = map[y[0]][x[0]];
                if (check(map, x[0], x[1], y[0], y[1], value)) {
                    sb.append(value);
                } else {
                    sb.append(partition(map, x[0], x[1], y[0], y[1]));
                }
            }
        }

        sb.append(")");

        return sb.toString();
    }

    private boolean check(int[][] map, int x1, int x2, int y1, int y2, int value) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (value != map[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }
}
